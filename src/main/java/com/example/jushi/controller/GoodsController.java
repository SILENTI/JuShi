package com.example.jushi.controller;

import com.example.jushi.model.Goods;
import com.example.jushi.service.IGoodsService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 居無何
 * */
@RestController
@RequestMapping("/jushi/goods")
public class GoodsController {

    @Autowired
    private IGoodsService IGoodsService;

    /**
     * 热销商品获取
     * @return
     */
    @RequestMapping("/hot_goods")
    public JsonResult<List<Goods>> goodsDis (){

        System.out.println("获取热销商品列表");

        //调用service层方法
        List<Goods> goodsList = IGoodsService.goodsDisplay();

        return new JsonResult<>(goodsList,"热销商品列表获取成功");
    }

//
//    *商品详情,根据传递过来的gId，查询到需要的商品详情信息
//    @GetMapping("/detail")
//    public String goodsDatail (int gId,Model model){
//        SeckillData seckillData = goodsService.findSeckillOfGoodsInfo(gId);
//        System.out.println("已售出："+seckillData.getgSales());
//        model.addAttribute(seckillData);
//        return "SeckilShow";
//    }



}
