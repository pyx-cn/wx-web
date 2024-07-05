package com.neuedu.demo.tijian.controller;


import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.service.CheckitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CheckitemController {

    @Autowired
    private CheckitemService checkitemService;

    @GetMapping("/getCheckitems")
    public Response getCheckitems(Integer smId){
        return Response.success(checkitemService.getCheckitems(smId));
    }

}
