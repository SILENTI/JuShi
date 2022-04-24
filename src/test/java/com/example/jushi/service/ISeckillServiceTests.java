package com.example.jushi.service;

import com.example.jushi.vo.SeckillGoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/19 15:43
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ISeckillServiceTests {

    @Autowired
    private ISeckillService seckillService;

    @Test
    public void SeckillJudge(){
        seckillService.seckillJudge(14,7,2,1,"居無何");
    }

    @Test
    public void showAllSeckillGoods (){
        List<SeckillGoodsVo> goodsVos = seckillService.showSeckill();
        for (SeckillGoodsVo goodsVo : goodsVos) {
            System.out.println(goodsVo.toString());
        }
    }

}
