package com.example.jushi.controller;

import com.example.jushi.model.SeckillData;
import com.example.jushi.service.GoodsService;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 居無何
 * */
@Controller
@RequestMapping({"/JuShi","/jushi"})
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**商品展示*/
    @RequestMapping("")
    public String goods (Model model){
        List<GoodsVo> goodsVos = goodsService.goodsShowAll();
        model.addAttribute("GoodsVo",goodsVos);
        return "index";
    }

    /**商品详情,根据传递过来的gId，查询到需要的商品详情信息*/
    @GetMapping("/detail")
    public String goodsDatail (int gId,Model model){
        SeckillData seckillData = goodsService.findSeckillOfGoodsInfo(gId);
        System.out.println("已售出："+seckillData.getgSales());
        model.addAttribute(seckillData);
        return "SeckilShow";
    }



}
