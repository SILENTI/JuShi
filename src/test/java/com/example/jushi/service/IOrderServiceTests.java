package com.example.jushi.service;

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
     * 新增order订单信息
     */
    @Test
    public void createOrder (){
        IOrderService.createOrder(14,7,new Integer[]{8},"居無何");
    }

}
