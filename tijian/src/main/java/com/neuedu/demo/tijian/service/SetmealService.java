package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.pojo.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【setmeal】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface SetmealService extends IService<Setmeal> {

    public List<Setmeal> getSetmeals(Integer type);

}
