package com.neuedu.demo.tijian.dto;

import com.neuedu.demo.tijian.pojo.Users;

public class LoginResponse {
    private Users user;
    private String token;


    public LoginResponse() {}

    public LoginResponse(Users user, String token) {
        this.user = user;
        this.token = token;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
