package com.neuedu.demo.tijian.controller;

import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class HostpitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/getHospitals")
    public Response getHospitals()
    {
        return Response.success(hospitalService.getHospitals());
    }

    @GetMapping("/getHospitalById")
    public Response getHospital(Integer hpId)
    {
        return Response.success(hospitalService.getOptById(hpId));
    }

}
