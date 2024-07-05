package com.neuedu.demo.tijian.controller;

import com.neuedu.demo.tijian.dto.LoginResponse;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Users;
import com.neuedu.demo.tijian.service.UsersService;
import com.neuedu.demo.tijian.util.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;
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
        return usersService.dealLogin(user);
    }

    @PostMapping("/register")
    public Response register(@RequestBody Users user) {
        return usersService.dealRegister(user);
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
