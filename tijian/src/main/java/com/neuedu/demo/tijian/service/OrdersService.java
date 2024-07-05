package com.neuedu.demo.tijian.service;

import com.neuedu.demo.tijian.dto.OrdersList;
import com.neuedu.demo.tijian.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liwenxuan
* @description 针对表【orders】的数据库操作Service
* @createDate 2024-06-13 12:05:42
*/
public interface OrdersService extends IService<Orders> {

    public Integer addOrder(Orders orders);

    public List<OrdersList> getByUserId(String userId);

    public int findByUserId(String userId);

    public List<Orders> getOrderResult(String userId);

}
