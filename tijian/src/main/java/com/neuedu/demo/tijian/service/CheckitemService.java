package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.Checkitem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【checkitem】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface CheckitemService extends IService<Checkitem> {

    public List<Checkitem> getCheckitems(Integer smId);

}
