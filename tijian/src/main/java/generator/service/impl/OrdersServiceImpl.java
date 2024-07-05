package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.pojo.Orders;
import generator.service.OrdersService;
import generator.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author liwenxuan
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2024-06-13 12:04:24
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




