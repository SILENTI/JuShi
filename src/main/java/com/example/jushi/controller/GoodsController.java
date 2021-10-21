package com.example.jushi.controller;

import com.example.jushi.model.Goods;
import com.example.jushi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    //商品展示
    @RequestMapping("/main")
    public Object commodityShow (Model model){
        List<Goods> all = goodsService.goodsShowAll();
        model.addAttribute("value",all);
        return all;
    }

}
