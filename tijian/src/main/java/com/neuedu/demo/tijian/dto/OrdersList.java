package com.neuedu.demo.tijian.dto;

import com.neuedu.demo.tijian.pojo.Orders;
import com.neuedu.demo.tijian.pojo.Setmeal;

public class OrdersList {

    private Orders orders;
    private Setmeal setmeal;

    public OrdersList(){}

    public OrdersList(Orders orders, Setmeal setmeal) {
        this.orders = orders;
        this.setmeal = setmeal;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Setmeal getSetmeal() {
        return setmeal;
    }

    public void setSetmeal(Setmeal setmeal) {
        this.setmeal = setmeal;
    }
}
