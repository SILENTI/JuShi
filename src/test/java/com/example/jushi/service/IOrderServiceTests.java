package com.example.jushi.service;

import com.example.jushi.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/3/14 13:43
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IOrderServiceTests {

    @Autowired
    private IOrderService IOrderService;

    /**
     * 购物车新增order订单信息
     */
    @Test
    public void createOrderByTrolley (){
        IOrderService.createOrderByTrolley(14,7,new Integer[]{8},"居無何");
    }

    /**
     * 商品直选下单
     */
    @Test
    public void createOrderByGoods (){
        Order order = IOrderService.createOrderByGoods(14,7,1,2,"居無何");
        System.out.println(order.toString());
    }

    @Test
    public void createOrderBySeckill (){
        Order order = IOrderService.creatOrderBySeckill(14,7,1,1,"居無何");
        System.out.println(order.toString());
    }


}
