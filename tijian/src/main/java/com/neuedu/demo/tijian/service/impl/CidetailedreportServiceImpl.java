package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.pojo.Cidetailedreport;
import com.neuedu.demo.tijian.pojo.Cireport;
import com.neuedu.demo.tijian.service.CidetailedreportService;
import com.neuedu.demo.tijian.mapper.CidetailedreportMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author liwenxuan
* @description 针对表【cidetailedreport】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class CidetailedreportServiceImpl extends ServiceImpl<CidetailedreportMapper, Cidetailedreport> implements CidetailedreportService{

    @Override
    public List<Cidetailedreport> getErrorReport(List<Cireport> cireports) {
        List<Cidetailedreport> errorReports = new ArrayList<>();
        for(Cireport cireport:cireports){
            for (Cidetailedreport cidetailedreport:cireport.getDetailedreports()){
                if(cidetailedreport.getIserror()==1){
                    errorReports.add(cidetailedreport);
                }
            }
        }
        return errorReports;
    }
}




