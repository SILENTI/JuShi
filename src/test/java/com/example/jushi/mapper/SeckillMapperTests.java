package com.example.jushi.mapper;

import com.example.jushi.model.Seckill;
import com.example.jushi.vo.SeckillGoodsVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/19 13:41
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SeckillMapperTests {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void selectSeckillBySid (){
        System.out.println(seckillMapper.selectSeckillBySid(1).toString());
    }

    @Test
    public void selectAllSeckill (){
        List<Seckill> seckills = seckillMapper.selectAllSeckill();
        for (Seckill seckill : seckills) {
            System.out.println(seckill.toString());
        }
    }

    @Test
    public void selectSeckillPage (){
        List<Seckill> seckills = seckillMapper.selectSeckillPage(0,1);
        for (Seckill seckill : seckills) {
            System.out.println(seckill.toString());
        }
    }

    @Test
    public void selectSeckillGoodsVo (){
        List<SeckillGoodsVo> seckillGoodsVos = seckillMapper.selectAllSeckillGoodsVo();
        for (SeckillGoodsVo seckillGoodsVo : seckillGoodsVos) {
            System.out.println(seckillGoodsVo.toString());
        }
    }
}
