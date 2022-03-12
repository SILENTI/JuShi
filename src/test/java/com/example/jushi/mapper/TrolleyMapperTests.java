package com.example.jushi.mapper;

import com.example.jushi.model.Trolley;
import com.example.jushi.vo.TrolleyVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 18:24
 * Description: trolleyMapper测试类
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class TrolleyMapperTests {

    @Autowired
    private TrolleyMapper trolleyMapper;

    /**
     * 添加商品到购物车
     */
    @Test
    public void insertTrolley (){
        Trolley trolley = new Trolley();
        trolley.setUid(14);
        trolley.setGid(3);
        trolley.setCreateTime(new Date());
        Integer record = trolleyMapper.insertTrolley(trolley);
        System.out.println("添加的记录："+record);
    }

    /**
    * 更新已加入购物车的商品的数量
    */
    @Test
    public void updateNumByTid (){
        System.out.println(trolleyMapper.updateNumByTid(2,3,"断舍离",new Timestamp(new Date().getTime())));
    }

    /**
     * 查询当前商品是否已加入购物车
     */
    @Test
    public void selectTrolleyByUidAndGid (){
        Trolley trolley = trolleyMapper.selectTrolleyByUidAndGid(14,4);
        System.out.println(trolley.toString());
    }

    /**
     * 根据trolley对象，更新num数据
     * */
    @Test
    public void updateNumForTrolleyByTid (){
        Trolley trolley = new Trolley();
        trolley.setTid(2);
        trolley.setGid(4);
        trolley.setUid(14);
        trolley.setNum(1);
        Integer record = trolleyMapper.updateNumForTrolleyByTid(trolley);
        System.out.println("数据修改记录："+record);
    }

    /**
     * 获取购物车列表
     */
    @Test
    public void selectTrolleyVoByUid (){
        List<TrolleyVo> trolleyVos = trolleyMapper.selectTrolleyVoByUid(15);
        for (TrolleyVo trolleyVo : trolleyVos) {
            System.out.println(trolleyVo.toString());
        }
    }

}
