package com.example.jushi.service;

import com.example.jushi.model.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 9:45
 * Description: 商品模块的业务层
 */
@Service
public interface IGoodsService {

    /**
     * 热销商品展示
     * @return 热销商品列表
     */
    List<Goods> goodsDisplay ();

    /**
     * 获取Goods对象信息
     * @param gid
     * @return
     */
    Goods selectGoodsByGid (Integer gid);

}
