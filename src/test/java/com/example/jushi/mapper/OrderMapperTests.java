package com.example.jushi.mapper;

import com.example.jushi.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/3/14 17:59
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTests {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加数据，返回新增后的主键id
     */
    @Test
    public void insertOrder (){
        Order order = new Order();
        order.setUid(15);
        order.setCneeName("南卿");
        System.out.println(orderMapper.insertOrder(order).toString());
        System.out.println("自增ID："+order.getOid());
    }

    /**
     * 根据aid查询
     */
    @Test
    public void selectOrderByAid (){
        System.out.println(orderMapper.selectOrderByAid(1).toString());
    }
}
