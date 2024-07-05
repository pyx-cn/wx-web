package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.mapper.CheckitemMapper;
import com.neuedu.demo.tijian.pojo.Setmeal;
import com.neuedu.demo.tijian.service.CheckitemService;
import com.neuedu.demo.tijian.service.SetmealService;
import com.neuedu.demo.tijian.mapper.SetmealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【setmeal】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService{

    @Autowired
    private SetmealMapper setmealMapper;

    @Autowired
    private CheckitemService checkitemService;

    @Override
    public List<Setmeal> getSetmeals(Integer type) {
        QueryWrapper<Setmeal> wrapper = new QueryWrapper<Setmeal>().eq("type",type);
        List<Setmeal> setmeals = setmealMapper.selectList(wrapper);
        for (Setmeal setmeal : setmeals){
            setmeal.setCheckitems(checkitemService.getCheckitems(setmeal.getSmid()));
        }
        return setmeals;
    }
}




