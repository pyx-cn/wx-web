package com.neuedu.demo.tijian.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.neuedu.demo.tijian.config.AliPayConfig;
import com.neuedu.demo.tijian.dto.Alipay;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.mapper.OrdersMapper;
import com.neuedu.demo.tijian.mapper.SetmealMapper;
import com.neuedu.demo.tijian.pojo.Orders;
import com.neuedu.demo.tijian.pojo.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class PayController {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AliPayConfig aliPayConfig;

    @Autowired
    private SetmealMapper setmealMapper;


    @GetMapping("/alipay")
    public void alipay(Integer orderId, HttpServletResponse httpResponse) throws
            IOException {

        // 1. 创建Client，通用SDK提供的Client，负责调用支付宝的API
        AlipayClient alipayClient = new DefaultAlipayClient(
                aliPayConfig.getGATEWAY_URL(), aliPayConfig.getAPP_ID(),
                aliPayConfig.getAPP_PRIVATE_KEY(), aliPayConfig.getFORMAT(),
                aliPayConfig.getCHARSET(), aliPayConfig.getALIPAY_PUBLIC_KEY(),
                aliPayConfig.getSIGN_TYPE());

        // 2. 创建 Request并设置Request参数
        Orders order = ordersMapper.selectById(orderId);
        Setmeal setmeal = setmealMapper.selectById(order.getSmid());

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();  // 发送请求的 Request类
        request.setNotifyUrl(aliPayConfig.getNOTIFY_URL());
        request.setReturnUrl(aliPayConfig.getRETURN_URL());

        System.out.println(aliPayConfig.getRETURN_URL());

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderid());  // 我们自己生成的订单编号
        bizContent.put("total_amount", setmeal.getPrice()); // 订单的总金额
        bizContent.put("subject", setmeal.getName());   // 支付的名称
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");  // 固定配置
        request.setBizContent(bizContent.toString());

        // 执行请求，拿到响应的结果，返回给浏览器
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        System.out.println(456);

        httpResponse.setContentType("text/html;charset=" + aliPayConfig.getCHARSET());
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @PostMapping("/notify")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");
            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");

            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getALIPAY_PUBLIC_KEY(), "UTF-8"); // 验证签名
            // 支付宝验签
            if (checkSignature) {
                // 验签通过
                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
            }
        }
        return "success";
    }

    @GetMapping(value = "/returnUrl")
    public void returnUrl(HttpServletRequest request, HttpServletResponse
            response)
            throws IOException, AlipayApiException {

        System.out.println(123);

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr +
                        values[i] + ",";
            }
            // 解决乱码
            valueStr = new String(valueStr.getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8);
            params.put(name, valueStr);
        }

        System.out.println(params);// 查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                aliPayConfig.getALIPAY_PUBLIC_KEY(), aliPayConfig.getCHARSET(),
                aliPayConfig.getSIGN_TYPE()); // 调用SDK验证签名
        // 验证签名通过
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new
                    String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            // 支付宝交易号
            String trade_no = new
                    String(request.getParameter("trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            // 付款金额
            String total_amount = new
                    String(request.getParameter("total_amount").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            System.out.println("商户订单号 = " + out_trade_no);
            System.out.println("支付宝交易号 = " + trade_no);
            System.out.println("付款金额 = " + total_amount);

            // 支付成功，修改支付状态

            System.out.println("success");

//            Orders orders = new Orders();
//            orders.setOrderId(Integer.valueOf(out_trade_no));
//            orders.setState(2);
//            ordersMapper.updateById(orders);
            response.sendRedirect("http://localhost:5173/appointmentsuccess");
        } else {
            System.out.println("fail");
        }
    }

    @PostMapping(value = "/returnUrl")
    public void returnURL(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println(123);

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (String name : requestParams.keySet()) {
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr +
                        values[i] + ",";
            }
            // 解决乱码
            valueStr = new String(valueStr.getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.UTF_8);
            params.put(name, valueStr);
        }

        System.out.println(params);// 查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                aliPayConfig.getALIPAY_PUBLIC_KEY(), aliPayConfig.getCHARSET(),
                aliPayConfig.getSIGN_TYPE()); // 调用SDK验证签名
        // 验证签名通过
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new
                    String(request.getParameter("out_trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            // 支付宝交易号
            String trade_no = new
                    String(request.getParameter("trade_no").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            // 付款金额
            String total_amount = new
                    String(request.getParameter("total_amount").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            System.out.println("商户订单号 = " + out_trade_no);
            System.out.println("支付宝交易号 = " + trade_no);
            System.out.println("付款金额 = " + total_amount);

            // 支付成功，修改支付状态

            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }

    @GetMapping("/return")
    public Response returnPay(Integer orderId) throws AlipayApiException {
        // 7天无理由退款
        LocalDate now = LocalDate.now();
        Orders order = ordersMapper.selectById(orderId);
        if (order != null) {
            // hutool工具类，判断时间间隔
            long between = now.toEpochDay() - order.getOrderdate().toEpochDay();
            if (between > 7) {
                return Response.error(-1, "该订单已超过7天，不支持退款");
            }
        }
        // 1. 创建Client，通用SDK提供的Client，负责调用支付宝的API
        AlipayClient alipayClient = new DefaultAlipayClient(
                aliPayConfig.getGATEWAY_URL(), aliPayConfig.getAPP_ID(),
                aliPayConfig.getAPP_PRIVATE_KEY(), aliPayConfig.getFORMAT(),
                aliPayConfig.getCHARSET(), aliPayConfig.getALIPAY_PUBLIC_KEY(),
                aliPayConfig.getSIGN_TYPE());

        // 2. 创建 Request，设置参数
        Setmeal setmeal = setmealMapper.selectById(order.getSmid());

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", order.getOrderid());  // 我们自己生成的订单编号
        bizContent.put("total_amount", setmeal.getPrice()); // 订单的总金额
        bizContent.put("subject", setmeal.getName());   // 支付的名称

        // 返回参数选项，按需传入
        //JSONArray queryOptions = new JSONArray();
        //queryOptions.add("refund_detail_item_list");
        //bizContent.put("query_options", queryOptions);

        request.setBizContent(bizContent.toString());

        // 3. 执行请求
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {  // 退款成功，isSuccess 为true
            System.out.println("调用成功");

            // 4. 更新数据库状态

            return Response.success();
        } else {   // 退款失败，isSuccess 为false
            System.out.println(response.getBody());
            return Response.error(response.getBody());
        }

    }


}
