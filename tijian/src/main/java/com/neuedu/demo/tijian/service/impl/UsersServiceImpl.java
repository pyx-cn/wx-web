package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.pojo.Users;
import com.neuedu.demo.tijian.service.UsersService;
import com.neuedu.demo.tijian.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author liwenxuan
* @description 针对表【users】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService{

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users login(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<Users>().eq("userId", user.getUserid())
                .eq("password", user.getPassword());
        Users u = usersMapper.selectOne(wrapper);
        System.out.println(u.getBirthday());
        return u;
    }

    @Override
    public Users register(Users user) {
        user.setUsertype(1);
        usersMapper.insert(user);
        return user;
    }
}




