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
public class GoodsServiceTests {

    @Autowired
    private GoodsService goodsService;

    /**
     * 获取热销商品列表
     * */
    @Test
    public void goodsDisplay (){
         List<Goods> goodsList = goodsService.goodsDisplay();
        for (Goods goods : goodsList) {
            System.out.println(goods.toString());
        }
    }

}
