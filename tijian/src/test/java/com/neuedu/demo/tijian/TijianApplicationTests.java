package com.neuedu.demo.tijian;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neuedu.demo.tijian.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TijianApplicationTests {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    void contextLoads() {
    }

}
