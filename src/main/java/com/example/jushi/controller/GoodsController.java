package com.example.jushi.controller;

import com.example.jushi.service.GoodsService;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/JuShi")
    public String goods (Model model){
        List<GoodsVo> goodsVos = goodsService.goodsShowAll();
        model.addAttribute("GoodsVo",goodsVos);
        return "GoodsShow";
    }

    @GetMapping("/")
    public String mode(){
        return "Login";
    }



}
