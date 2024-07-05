package com.neuedu.demo.tijian.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.demo.tijian.dto.Reporter;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Cireport;
import com.neuedu.demo.tijian.pojo.Overallresult;
import com.neuedu.demo.tijian.service.CidetailedreportService;
import com.neuedu.demo.tijian.service.CireportService;
import com.neuedu.demo.tijian.service.OrdersService;
import com.neuedu.demo.tijian.service.OverallresultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CireportController {

    @Autowired
    CireportService cireportService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    OverallresultService overallresultService;

    @Autowired
    CidetailedreportService cidetailedreportService;

    @GetMapping("/getCireport")
    public Response getCireport(Integer orderId)
    {
        if(ordersService.getById(orderId) == null){
            return Response.error("订单不存在");
        }
        else {
            QueryWrapper<Overallresult> wrapper = new QueryWrapper<Overallresult>().eq("orderId",orderId);
            Reporter reporter = new Reporter();
            List<Cireport> cireports = cireportService.getCireport(orderId);
            reporter.setCireports(cireports);
            reporter.setErrorReports(cidetailedreportService.getErrorReport(cireports));
            reporter.setOverallresult(overallresultService.list(wrapper));
            return Response.success(reporter);
        }
    }

}
