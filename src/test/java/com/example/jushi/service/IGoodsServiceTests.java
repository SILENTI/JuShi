package com.example.jushi.service;

import com.example.jushi.model.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 10:07
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IGoodsServiceTests {

    @Autowired
    private IGoodsService IGoodsService;

    /**
     * 获取热销商品列表
     * */
    @Test
    public void goodsDisplay (){
         List<Goods> goodsList = IGoodsService.goodsDisplay();
        for (Goods goods : goodsList) {
            System.out.println(goods.toString());
        }
    }

    @Test
    public void getGoods () {
        System.out.println(IGoodsService.selectGoodsByGid(1).toString());
    }

}
