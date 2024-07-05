package com.neuedu.demo.tijian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.demo.tijian.dto.OrdersList;
import com.neuedu.demo.tijian.mapper.*;
import com.neuedu.demo.tijian.pojo.*;
import com.neuedu.demo.tijian.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author liwenxuan
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2024-06-13 12:05:42
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService{

    @Autowired
    public OrdersMapper ordersMapper;

    @Autowired
    private SetmealdetailedMapper setmealdetailedMapper;

    @Autowired
    private CireportMapper cireportMapper;

    @Autowired
    private CheckitemMapper checkitemMapper;

    @Autowired
    private CheckitemdetailedMapper checkitemdetailedMapper;

    @Autowired
    private CidetailedreportMapper cidetailedreportMapper;

    @Autowired
    private HospitalMapper hospitalMapper;

    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    @Transactional
    public Integer addOrder(Orders orders) {

        String[] hospitalRules = hospitalMapper.selectById(orders.getHpid()).getRule().split(",");
        int maximum =  Integer.valueOf(hospitalRules[LocalDate.now().getDayOfWeek().getValue()]);

        synchronized (this){
            if(ordersMapper.selectCount(new QueryWrapper<Orders>().eq("orderDate",orders.getOrderid())) <= maximum)
                if(ordersMapper.selectCount(new QueryWrapper<Orders>().eq("orderDate",orders.getOrderid())) <= maximum){
                    orders.setState(1);
                    ordersMapper.insert(orders);
                }
        }

        List<Integer> ciIds = setmealdetailedMapper.getClidIds(orders.getSmid());
        for(Integer ciId : ciIds){
            Checkitem checkitem = checkitemMapper.selectById(ciId);
            Cireport cireport = new Cireport();
            cireport.setCiid(ciId);
            cireport.setOrderid(orders.getOrderid());
            cireport.setCiname(checkitem.getCiname());
            cireportMapper.insert(cireport);

            List<Integer> cdIds = checkitemdetailedMapper.getCdIdIds(ciId);
            for(Integer cdId : cdIds){
                Checkitemdetailed checkitemdetailed = checkitemdetailedMapper.selectById(cdId);
                Cidetailedreport cidetailedreport = new Cidetailedreport();
                cidetailedreport.setName(checkitemdetailed.getName());
                cidetailedreport.setUnit(checkitemdetailed.getUnit());
                cidetailedreport.setMinrange(checkitemdetailed.getMinrange());
                cidetailedreport.setMaxrange(checkitemdetailed.getMaxrange());
                cidetailedreport.setNormalvalue(checkitemdetailed.getNormalvalue());
                cidetailedreport.setNormalvaluestring(checkitemdetailed.getNormalvaluestring());
                cidetailedreport.setType(checkitemdetailed.getType());
                cidetailedreport.setCiid(ciId);
                cidetailedreport.setOrderid(orders.getOrderid());
                cidetailedreportMapper.insert(cidetailedreport);
            }

        }
        return orders.getOrderid();
    }

    @Override
    public List<OrdersList> getByUserId(String userId) {
        List<OrdersList> ordersList = new ArrayList<>();
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>().eq("userId",userId);
        List<Orders> orders = ordersMapper.selectList(queryWrapper);
        for(Orders order : orders){
            ordersList.add(new OrdersList(order,setmealMapper.selectById(order.getSmid())));
        }
        return ordersList;
    }

    @Override
    public int findByUserId(String userId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>().eq("userId",userId).eq("orderDate",2);
        return Math.toIntExact(ordersMapper.selectCount(queryWrapper));
    }

    @Override
    public List<Orders> getOrderResult(String userId) {
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<Orders>().eq("userId",userId).eq("state",3);
        List<Orders> orders = ordersMapper.selectList(queryWrapper);
        for (Orders order : orders){
            order.setHospitalName(hospitalMapper.selectById(order.getHpid()).getName());
        }
        return orders;
    }

    @Scheduled(cron = "0 0 18 * * ?")
    public void clear(){
        List<Orders> orders = ordersMapper.selectList(new QueryWrapper<Orders>().eq("state",1).eq("state",0));
        for(Orders order : orders){
            if(order.getOrderdate().isBefore(LocalDate.now())){
                order.setState(4);
                ordersMapper.updateById(order);
            }
        }
        System.out.println("这是job2");
    }

}




