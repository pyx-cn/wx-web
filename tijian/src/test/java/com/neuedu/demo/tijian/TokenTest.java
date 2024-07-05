package com.neuedu.demo.tijian;

import com.neuedu.demo.tijian.pojo.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class TokenTest {

    @Test
    public void test1() {
        Users users = new Users();
        users.setUserid("12345671111");
        users.setRealname("叶文洁");
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", users);

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,"itheima")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void test2(){
        Claims abcd = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzUxMiJ9.eyJwYXNzd29yZCI6IjEyMyIsImV4cCI6MTcxOTM3NzgxNCwidXNlcklkIjoiMTIzNDU2NzExMTEifQ.A9uzpQQkCGBTcuOG9FTrdzZ4nhABTyJD5FCfZ3IVBkVS5NdulX1N2bU8Ia06kfeojknwtBAnYtf-GgPR08k2hg")
                .getBody();//获取令牌中的载荷
        System.out.println(abcd);
    }

}
