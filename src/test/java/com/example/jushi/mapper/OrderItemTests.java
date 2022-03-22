package com.example.jushi.mapper;

import com.example.jushi.model.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/3/21 11:38
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderItemTests {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Test
    public void selectSeckillByUidAndGid (){
        OrderItem orderItem = orderItemMapper.selectSeckillByUIdAndGid(14,1);

        System.out.println(orderItem.toString());

    }

}
