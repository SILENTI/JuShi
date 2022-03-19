package com.example.jushi.controller;

import com.example.jushi.model.Order;
import com.example.jushi.model.User;
import com.example.jushi.service.IOrderService;
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
    private IOrderService IOrderService;

    /**
     * 中购物车中的商品选中，创建订单
     * @param aid
     * @param tid
     * @param session
     * @return
     */
    @RequestMapping("/create_order_trolley")
    public JsonResult<Order> createOrderByTrolley (Integer aid, Integer [] tid, HttpSession session){

        User user = (User) session.getAttribute("user");

        Order order = IOrderService.createOrderByTrolley(user.getUid(),aid,tid,user.getUsername());

        return new JsonResult<Order>(order,"数据新增成功") ;
    }

    /**
     * 直接商品下单
     * @param aid
     * @param gid
     * @param session
     * @return
     */
    @RequestMapping("/create_order_goods")
    public JsonResult<Order> createOrderByGoods (Integer aid, Integer gid, Integer num, HttpSession session){

        User user = (User) session.getAttribute("user");

        Order order = IOrderService.createOrderByGoods(user.getUid(),aid,gid,num,user.getUsername());

        return new JsonResult<>(order,"数据新增成功");
    }



}
