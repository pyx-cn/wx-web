package com.neuedu.demo.tijian.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@CrossOrigin
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        resp.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有域名跨域访问
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS"); // 允许的请求方法
        resp.setHeader("Access-Control-Allow-Headers", "Authorization"); // 允许的请求头

        /*1、获取访问路径*/
        String url = req.getRequestURL().toString();

        System.out.println(url);

        /*2、判断url中是否包含login，如果包含，说明是登录接口，放行*/
        if(url.contains("login")){
            return true;
        }

        /*3、获取请求头中的令牌（token）*/
        String jwt = req.getHeader("Authorization");
        System.out.println("jwt: " + jwt);

        /*4、判断令牌是否存在，如果未存在，返回错误数据*/
        if(!StringUtils.hasLength(jwt)){
            Response error= Response.error("Not_Login");
            //将error转换为json，因为这不是controller，所以需要手动将error转为json数据返回前端
            String notLogin = JSONObject.toJSONString(error);

            resp.getWriter().write(notLogin);
            return false;
        }

        //String[] jwtArray = jwt.split(" ");
        //jwt = jwtArray[1];
        //System.out.println("jwt: " + jwt);

        /*5、解析token,如果解析失败，返回错误结果（未登录）*/
        try {
            JwtUtil.parseJWT(jwt);
        }catch (Exception e){
            Response error= Response.error("Not_Login");
            //将error转换为json，因为这不是controller，所以需要手动将error转为json数据返回前端
            String notLogin = JSONObject.toJSONString(error);

            resp.getWriter().write(notLogin);
            return false;
        }

        System.out.println("放行");
        /*6、放行*/
        return true;
    }

    @Override//目标方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle执行了");

    }

    @Override//视图渲染完后执行，最后执行的
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion执行了");
    }



}
