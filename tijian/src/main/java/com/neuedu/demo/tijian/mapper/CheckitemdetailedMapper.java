package com.neuedu.demo.tijian.mapper;

import com.neuedu.demo.tijian.pojo.Checkitemdetailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【checkitemdetailed】的数据库操作Mapper
* @createDate 2024-06-13 12:05:42
* @Entity com.neuedu.demo.tijian.pojo.Checkitemdetailed
*/
public interface CheckitemdetailedMapper extends BaseMapper<Checkitemdetailed> {

    @Select("select cdId from checkitemdetailed where ciId=#{ciId}")
    public List<Integer> getCdIdIds(Integer ciId);

}




