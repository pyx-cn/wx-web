package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.dto.Response;
import com.neuedu.demo.tijian.pojo.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author liwenxuan
* @description 针对表【users】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface UsersService extends IService<Users> {

    public Users login(Users user);

    public Response dealLogin(Users user);

    public Users register(Users user);

    public Response dealRegister(Users user);

}
