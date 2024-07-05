package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.mapper.SetmealMapper;
import com.neuedu.demo.tijian.mapper.SetmealdetailedMapper;
import com.neuedu.demo.tijian.pojo.Checkitem;
import com.neuedu.demo.tijian.service.CheckitemService;
import com.neuedu.demo.tijian.mapper.CheckitemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author liwenxuan
* @description 针对表【checkitem】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class CheckitemServiceImpl extends ServiceImpl<CheckitemMapper, Checkitem> implements CheckitemService{

    @Autowired
    private SetmealdetailedMapper setmealdetailedMapper;

    @Autowired
    private CheckitemMapper checkitemMapper;

    @Override
    public List<Checkitem> getCheckitems(Integer smId) {
        List<Integer> ciIds = setmealdetailedMapper.getClidIds(smId);
        List<Checkitem> checkItems = new ArrayList<>();
        for(int i = 0; i < ciIds.size(); i++){
            checkItems.add(checkitemMapper.selectById(ciIds.get(i)));
        }
        return checkItems;
    }
}




