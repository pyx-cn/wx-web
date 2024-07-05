package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.dto.LoginResponse;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Users;
import com.neuedu.demo.tijian.service.UsersService;
import com.neuedu.demo.tijian.mapper.UsersMapper;
import com.neuedu.demo.tijian.util.JwtUtil;
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

    public Response dealLogin(Users user) {
        Users u = getById(user.getUserid());
        if(u==null){
            return Response.error(101,"用户不存在");
        }
        else if(user.getPassword().equals(u.getPassword())){
//        else if(BCrypt.checkpw(user.getPassword(),u.getPassword())) {
            u.setPassword(null);
            return Response.success(new LoginResponse(u, JwtUtil.getJWT(u)));
            //return Response.success(u);
        }
        else return Response.error(102,"用户名或密码错误");
    }

    @Override
    public Users register(Users user) {
        user.setUsertype(1);
        usersMapper.insert(user);
        return user;
    }

    public Response dealRegister(Users user) {
        Users u = getById(user.getUserid());
        if(u!=null){
            return Response.error(103,"用户名已存在");
        } else {
//            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            return Response.success(register(user));
        }
    }
}




