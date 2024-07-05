package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.Cidetailedreport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neuedu.demo.tijian.pojo.Cireport;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【cidetailedreport】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface CidetailedreportService extends IService<Cidetailedreport> {

    public List<Cidetailedreport> getErrorReport(List<Cireport> cireports);

}
