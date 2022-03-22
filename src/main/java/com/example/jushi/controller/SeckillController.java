package com.example.jushi.controller;

import com.example.jushi.model.Order;
import com.example.jushi.model.User;
import com.example.jushi.service.IOrderService;
import com.example.jushi.service.ISeckillService;
import com.example.jushi.util.JsonResult;
import com.example.jushi.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
@RestController
@RequestMapping("/jushi/seckill")
public class SeckillController {

    @Autowired
    private ISeckillService ISeckillService;


    @Autowired
    private IOrderService IOrderService;

    /**
     * 秒杀商品的展示
     * @return
     */
    @RequestMapping("/show_seckill")
    public JsonResult<List<SeckillGoodsVo>> showSeckillGoods (){

        List<SeckillGoodsVo> seckillGoodsVos = ISeckillService.showSeckill();

        return new JsonResult<>(seckillGoodsVos,"数据获取成功");
    }

    /**
     * 秒杀商品订单
     * @param aid
     * @param sid
     * @param num
     * @param session
     * @return
     */
    @RequestMapping("/create_seckill_order")
    public JsonResult<Order> createOrderBySeckill (Integer aid, Integer sid, Integer num, HttpSession session){

        //获取user对象
        User user = (User) session.getAttribute("user");

        //检验秒杀条件是否符合
        ISeckillService.seckillJudge(user.getUid(),aid,sid,num, user.getUsername());

        //进行商品下单
        Order order = IOrderService.creatOrderBySeckill(user.getUid(), aid, sid, num, user.getUsername());

        return new JsonResult<>(order,"下单成功");
    }

}
