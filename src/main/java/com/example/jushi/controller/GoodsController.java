package com.example.jushi.controller;

import com.example.jushi.model.Goods;
import com.example.jushi.service.GoodsService;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;

/**
 * @author 居無何
 * */
@Controller
@RequestMapping("/JuShi")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**商品展示*/
    @RequestMapping("")
    public String goods (Model model){
        List<GoodsVo> goodsVos = goodsService.goodsShowAll();
        model.addAttribute("GoodsVo",goodsVos);
        return "GoodsShow";
    }

    /**商品详情*/
    @GetMapping("/detail")
    public String goodsDatail (int gId,Model model){
        Goods goodsInfo = goodsService.findGoodsInfo(gId);
        model.addAttribute(goodsInfo);
        return "GoodsDetail";
    }



}
