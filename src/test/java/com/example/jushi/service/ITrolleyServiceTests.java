package com.example.jushi.service;

import com.example.jushi.model.Trolley;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/3/10 20:19
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ITrolleyServiceTests {

    @Autowired
    private ITrolleyService ITrolleyService;

    /**
     * 将商品加入购物车中
     * */
    @Test
    public void addGoodsTrolley (){
        ITrolleyService.addGoodsTrolley(1,10,15,"南卿%");
    }

    /**
     * 根据获取Trolley对象
     */
    @Test
    public void selectTrolley (){
        Trolley trolley = ITrolleyService.selectTrolleyByTid(2,14);
        System.out.println(trolley.toString());
    }

}
