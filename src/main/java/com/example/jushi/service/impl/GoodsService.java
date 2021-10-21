package com.example.jushi.service.impl;

import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService implements com.example.jushi.service.GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> goodsShowAll() {
        return goodsMapper.selectAll();
    }


}
