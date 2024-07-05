package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.pojo.Hospital;
import com.neuedu.demo.tijian.pojo.Users;
import com.neuedu.demo.tijian.service.HospitalService;
import com.neuedu.demo.tijian.mapper.HospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【hospital】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class HospitalServiceImpl extends ServiceImpl<HospitalMapper, Hospital> implements HospitalService{

    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public List<Hospital> getHospitals(){
        QueryWrapper<Hospital> wrapper = new QueryWrapper<Hospital>().eq("state", 1);
        return hospitalMapper.selectList(wrapper);
    }
}




