package com.example.jushi.service.impl;

import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.model.Goods;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 居無何 
 * @// TODO: 2021/10/29  
 * */
@Service
public class GoodsService implements com.example.jushi.service.GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> goodsShowAll() {
        List<GoodsVo> goodsVos = new LinkedList<>();
        for (Goods goods : goodsMapper.selectAll()) {
            GoodsVo vo = new GoodsVo();
            vo.setGId(goods.getgId());
            vo.setGName(goods.getgName());
            vo.setGPrice(goods.getgPrice());
            vo.setGStock(goods.getgStock());
            vo.setGType(goods.getgType());
            vo.setGImg(goods.getgImg());
            goodsVos.add(vo);
        }

        return goodsVos;
    }

    @Override
    public Goods findGoodsInfo(Integer gId) {
        return goodsMapper.selectByPrimaryKey(gId);
    }
}
