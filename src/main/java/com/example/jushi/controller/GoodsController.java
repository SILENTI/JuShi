package com.example.jushi.controller;

import com.example.jushi.model.Goods;
import com.example.jushi.service.GoodsService;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/")
    public String goods (Model model){
        List<GoodsVo> goodsVos = goodsService.goodsShowAll();
        model.addAttribute("GoodsVo",goodsVos);
        return "GoodsShow";
    }

}
