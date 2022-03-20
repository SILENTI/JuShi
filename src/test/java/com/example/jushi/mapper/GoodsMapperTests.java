package com.example.jushi.mapper;

import com.example.jushi.model.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 9:32
 * Description: GoodsMapper测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsMapperTests {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 根据商品销售量获取商品的列表
     * */
    @Test
    public void selectAllGoods (){
        List<Goods> goods = goodsMapper.selectAllGoods();
        for (Goods good : goods) {
            System.out.println(good.toString());
        }
    }

    /**
     * 根据gid获取商品的价格
     */
    @Test
    public void getPriceByGid (){
            System.out.println(goodsMapper.selectPriceByGid(4));
    }

    /**
     * 获取goods
     */
    @Test
    public void selectGoodsByGid (){
        System.out.println(goodsMapper.selectGoodsByGid(1).toString());
    }

    /**
     * 根据gid，改变商品库存
     */
    @Test
    public void updateGoodsNumByGid (){
        goodsMapper.updateGoodsNumByGid(4,10);
    }

}
