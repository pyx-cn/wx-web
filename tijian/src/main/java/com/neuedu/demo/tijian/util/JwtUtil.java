package com.neuedu.demo.tijian.util;

import com.neuedu.demo.tijian.pojo.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JwtUtil {
    /**
     * 生成jwt令牌
     * */
    public static String getJWT(Users users){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId",users.getUserid());
        claims.put("password",users.getPassword());

        String jwt = Jwts.builder() //Jwts是jwt依赖包提供的工具类，直接调用
                .signWith(SignatureAlgorithm.HS512,"huanong")//加密方式，密钥(长度大于3个字符)
                .setClaims(claims)//载荷数据(自定义的内容)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//令牌有效期
                .compact();

        System.out.println(jwt);

        return jwt;
    }

    /**
     * 解析jwt令牌
     * */
    public static void parseJWT(String token){
        System.out.println(token);
        Claims abcd = Jwts.parser()
                .setSigningKey("huanong")//指定签名密钥
                .parseClaimsJws(token)
                .getBody();//获取令牌中的载荷
        System.out.println(abcd);
    }
}
