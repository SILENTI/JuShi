package com.example.jushi.controller;

import com.example.jushi.model.Order;
import com.example.jushi.model.User;
import com.example.jushi.service.OrderService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * date: 2022/3/15 12:52
 * Description:
 */
@RestController
@RequestMapping("/jushi/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/create_order")
    public JsonResult<Order> createOrder (Integer aid, Integer [] tid, HttpSession session){

        User user = (User) session.getAttribute("user");

        Order order = orderService.createOrder(user.getUid(),aid,tid,user.getUsername());

        return new JsonResult<Order>(order,"数据新增成功") ;
    }

}
