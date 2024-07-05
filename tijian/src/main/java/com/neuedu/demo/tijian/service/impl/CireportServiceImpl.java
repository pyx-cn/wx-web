package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.mapper.CidetailedreportMapper;
import com.neuedu.demo.tijian.pojo.Cidetailedreport;
import com.neuedu.demo.tijian.pojo.Cireport;
import com.neuedu.demo.tijian.service.CireportService;
import com.neuedu.demo.tijian.mapper.CireportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【cireport】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class CireportServiceImpl extends ServiceImpl<CireportMapper, Cireport> implements CireportService{

    @Autowired
    CireportMapper cireportMapper;

    @Autowired
    CidetailedreportMapper cidetailedreportMapper;


    @Override
    public List<Cireport> getCireport(Integer orderId) {
        QueryWrapper<Cireport> queryWrapper = new QueryWrapper<Cireport>().eq("orderId", orderId);
        List<Cireport> cireports = cireportMapper.selectList(queryWrapper);
        for (Cireport cireport : cireports){
            QueryWrapper<Cidetailedreport> wrapper = new QueryWrapper<Cidetailedreport>()
                    .eq("ciId", cireport.getCiid())
                    .eq("orderId", orderId);
            cireport.setDetailedreports(cidetailedreportMapper.selectList(wrapper));
        }
        return cireports;
    }
}




