package com.example.jushi.service.impl;


import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.model.Goods;
import com.example.jushi.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 热销商品展示
     * @return 热销商品列表
     */
    @Override
    public List<Goods> goodsDisplay() {

        List<Goods> goodsList = goodsMapper.selectAllGoods();

        return goodsList;
    }
}
