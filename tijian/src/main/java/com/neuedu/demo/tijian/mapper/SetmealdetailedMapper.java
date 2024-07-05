package com.neuedu.demo.tijian.mapper;

import com.neuedu.demo.tijian.pojo.Setmealdetailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【setmealdetailed】的数据库操作Mapper
* @createDate 2024-06-13 12:05:42
* @Entity com.neuedu.demo.tijian.pojo.Setmealdetailed
*/
public interface SetmealdetailedMapper extends BaseMapper<Setmealdetailed> {

    @Select("select ciId from setmealdetailed where smId=#{smId}")
    public List<Integer> getClidIds(Integer smId);
}




