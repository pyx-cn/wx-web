package com.neuedu.demo.tijian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.demo.tijian.dto.OrdersList;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Orders;
import com.neuedu.demo.tijian.service.CalendarService;
import com.neuedu.demo.tijian.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CalendarService calendarService;

    @PostMapping("/addOrder")
    public Response addOrder(@RequestBody Orders orders) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>()
                .eq("userId", orders.getUserid())
                .eq("hpId", orders.getHpid())
                .eq("smId", orders.getSmid())
                .eq("orderDate", orders.getOrderdate());
        Orders orders1 = ordersService.getOne(queryWrapper);
        if (orders1 != null) {
            if (orders1.getState() == 1) {
                return Response.error(111, "不可重复预约");
            } else if (orders1.getState() == 0) {
                return reOrder(orders1.getOrderid());
            }
        }

        Integer orderId = ordersService.addOrder(orders);
        if (orderId != null) {
            return Response.success(orderId);
        } else return Response.error("添加失败");

    }

    @PostMapping("/delOrder")
    public Response delOrder(Integer orderId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>()
                .eq("orderId", orderId);
        Orders orders = ordersService.getOne(queryWrapper);
        if (orders != null) {
            return Response.success(ordersService.remove(queryWrapper));
        } else {
            return Response.error("删除失败，不存在该订单");
        }
    }

    @PostMapping("/cancelOrder")
    public Response cancelOrder(Integer orderId) {
        Orders orders = ordersService.getById(orderId);
        if (orders == null) {
            return Response.error("查询失败");
        } else if (orders.getState() == 0) {
            return Response.error(112, "该订单已取消");
        } else {
            orders.setState(0);
            return ordersService.updateById(orders) ? Response.success() : Response.error("取消失败");
        }
    }

    @PostMapping("/reOrder")
    public Response reOrder(Integer orderId) {
        Orders orders = ordersService.getById(orderId);
        if (orders == null) {
            return Response.error("查询失败");
        } else if (orders.getState() != 0) {
            return Response.error(113, "该订单没有被取消");
        } else {
            orders.setState(1);
            return ordersService.updateById(orders) ? Response.success(orderId) : Response.error("取消失败");
        }
    }

    @GetMapping("/getOrdersById")
    public Response getOrdersById(Integer orderId) {
        Orders orders = ordersService.getById(orderId);
        if (orders == null) {
            return Response.error("查询失败");
        } else return Response.success(orders);
    }

    @GetMapping("/getOrdersByUserId")
    public Response getOrdersByUserId(String userId) {
        List<OrdersList> orders = ordersService.getByUserId(userId);
        if (orders != null) {
            return Response.success(orders);
        } else return Response.error("查询失败");
    }

    @GetMapping("/findOrderByUserId")
    public Response getOrderByUserId(String userId) {
        return Response.success(ordersService.findByUserId(userId));
    }



    @GetMapping("/getReporterList")
    public Response getReporterList(String userId) {
        return Response.success(ordersService.getOrderResult(userId));
    }


    @GetMapping("/getCalendar")
    public Response getCalendar(Integer year, Integer month, Integer hpId) {
        System.out.println("year:" + year + " month:" + month + " hpId:" + hpId);
        return Response.success(calendarService.getCalendar(year, month, hpId));
    }


}
