package com.example.jushi.service;

import com.example.jushi.model.OrderItem;
import com.example.jushi.model.Trolley;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/13 17:27
 * Description: 订单相关业务层
 */
@Service
public interface OrderService {

    /**
     * 创建订单信息
     * @param uid
     * @param adi
     * @param tid
     * @param userName
     */
    void createOrder (Integer uid,Integer adi,Integer [] tid,String userName);

    /**
     * 新增orderItem数据
     * @param orderItem
     */
    void createOrderItem (OrderItem orderItem);
}
