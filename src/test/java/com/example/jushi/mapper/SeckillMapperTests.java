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

    /**
     * 获取seckill信息根据sid
     * */
    @Test
    public void selectSeckillBySid (){
        System.out.println(seckillMapper.selectSeckillBySid(1).toString());
    }

    /**
     * 获取所有的seckill对象
     * */
    @Test
    public void selectAllSeckill (){
        List<Seckill> seckills = seckillMapper.selectAllSeckill();
        for (Seckill seckill : seckills) {
            System.out.println(seckill.toString());
        }
    }

    /**
     * 查询seckill，并分页
     * */
    @Test
    public void selectSeckillPage (){
        List<Seckill> seckills = seckillMapper.selectSeckillPage(0,1);
        for (Seckill seckill : seckills) {
            System.out.println(seckill.toString());
        }
    }

    /**
     * 查询商品展示信息
     * */
    @Test
    public void selectSeckillGoodsVo (){
        List<SeckillGoodsVo> seckillGoodsVos = seckillMapper.selectAllSeckillGoodsVo();
        for (SeckillGoodsVo seckillGoodsVo : seckillGoodsVos) {
            System.out.println(seckillGoodsVo.toString());
        }
    }

    /**
     * 修改商品库存
     * */
    @Test
    public void updateSeckillCount (){
        seckillMapper.updateSeckillNumBySid(2,100);
    }
}
