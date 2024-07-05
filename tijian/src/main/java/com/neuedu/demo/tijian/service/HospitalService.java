package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.Hospital;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【hospital】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface HospitalService extends IService<Hospital> {

    public List<Hospital> getHospitals();
}
