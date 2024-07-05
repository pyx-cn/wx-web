package com.neuedu.demo.tijian.controller;

import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @GetMapping("/getSetmeals")
    public Response getSetmeals(Integer type){
        return Response.success(setmealService.getSetmeals(type));
    }

    @GetMapping("/getSetmealById")
    public Response getSetmeal(Integer smId){
        return Response.success(setmealService.getById(smId));
    }

}
