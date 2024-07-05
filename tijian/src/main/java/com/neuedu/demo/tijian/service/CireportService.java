package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.Cireport;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【cireport】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface CireportService extends IService<Cireport> {

    public List<Cireport> getCireport(Integer orderId);

}
