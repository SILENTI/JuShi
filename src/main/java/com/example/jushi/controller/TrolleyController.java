package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.TrolleyService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 居無何
 * date: 2022/3/10 22:41
 * Description:
 */
@RestController
@RequestMapping("/jushi/goods")
public class TrolleyController {

    @Autowired
    private TrolleyService trolleyService;

    /**
     * 用户添加商品到购物车
     * @param gid
     * @param num
     * @param httpSession
     * @return
     */
    @RequestMapping("/add_goods_trolley")
    public JsonResult<Void> addGoodsTrolley (Integer gid,Integer num, HttpSession httpSession){

        User user = (User) httpSession.getAttribute("user");

        trolleyService.addGoodsTrolley(gid,num,user.getUid(), user.getUsername());

        return new JsonResult<Void>("添加成功");
    }
}
