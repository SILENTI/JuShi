package com.example.jushi.service.impl;

import com.example.jushi.mapper.GoodsMapper;
import com.example.jushi.mapper.SeckillMapper;
import com.example.jushi.model.Goods;
import com.example.jushi.model.Seckill;
import com.example.jushi.model.SeckillData;
import com.example.jushi.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 居無何
 * */
@Service
public class GoodsServiceImpl implements com.example.jushi.service.GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private SeckillMapper seckillMapper;

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
    public SeckillData findSeckillOfGoodsInfo(Integer gId) {
        Goods goods = goodsMapper.selectByPrimaryKey(gId);
        Seckill seckill = seckillMapper.selectByPrimaryKey(gId);
        SeckillData seckillData = new SeckillData();

        seckillData.setgId(goods.getgId());
        seckillData.setgName(goods.getgName());
        seckillData.setgImg(goods.getgImg());
        seckillData.setgType(goods.getgType());
        seckillData.setsStart(seckill.getsStart());
        seckillData.setsEnd(seckill.getsEnd());
        //秒杀价
        seckillData.setsPrice(seckill.getsPrice());
        //原价
        seckillData.setgPrice(goods.getgPrice());

        seckillData.setsCount(seckill.getsCount());

        return seckillData;
    }
}
