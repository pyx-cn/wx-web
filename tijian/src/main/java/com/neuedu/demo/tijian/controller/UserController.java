package com.neuedu.demo.tijian.controller;

import com.neuedu.demo.tijian.dto.LoginResponse;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Users;
import com.neuedu.demo.tijian.service.UsersService;
import com.neuedu.demo.tijian.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/test")
    public String test() {
        return "1234567";
    }

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public Response login(@RequestBody Users user) {
        Users u = usersService.getById(user.getUserid());
        if(u==null){
            return Response.error(101,"用户不存在");
        }
        else if(user.getPassword().equals(u.getPassword())){
            return Response.success(new LoginResponse(u,JwtUtil.getJWT(u)));
            //return Response.success(u);
        }
        else return Response.error(102,"用户名或密码错误");
    }

    @PostMapping("/register")
    public Response register(@RequestBody Users user) {
        Users u = usersService.getById(user.getUserid());
        if(u!=null){
            return Response.error(103,"用户名已存在");
        }
        else {
            return Response.success(usersService.register(user));
        }
    }

    @GetMapping("/getUser")
    public Response getUser(String userid) {
        Users user = usersService.getById(userid);
        if(user != null) {
            return Response.success(user);
        }
        return Response.error("参数错误");
    }

}
