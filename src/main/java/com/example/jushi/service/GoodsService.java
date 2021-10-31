package com.example.jushi.service;

import com.example.jushi.model.Goods;
import com.example.jushi.model.SeckillData;
import com.example.jushi.vo.GoodsVo;

import java.util.List;

/**
 * @author 居無何
 */
public interface GoodsService {

    /**
     * 商品展示，获取所有的商品信息
     * @return List<GoodsVo>
     * */
    List<GoodsVo> goodsShowAll ();

    /**
     * 根据gId，获取该商品详细信息
     * @param gId
     * @return SeckillData
     * */
    SeckillData findSeckillOfGoodsInfo(Integer gId);
}
