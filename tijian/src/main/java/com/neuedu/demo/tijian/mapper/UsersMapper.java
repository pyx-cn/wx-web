package com.neuedu.demo.tijian.mapper;

import com.neuedu.demo.tijian.pojo.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author liwenxuan
* @description 针对表【users】的数据库操作Mapper
* @createDate 2024-06-13 12:05:42
* @Entity com.neuedu.demo.tijian.pojo.Users
*/
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}




