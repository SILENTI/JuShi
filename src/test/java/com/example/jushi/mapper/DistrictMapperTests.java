package com.example.jushi.mapper;

import com.example.jushi.model.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 16:11
 * Description: DistrictMapper测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictMapperTests {

    @Autowired
    private DistrictMapper districtMapper;

    /**
     * 根据parent获取所有的信息
     */
    @Test
    public void selectByParent (){
        List<District> districts = districtMapper.selectByParent("86");
        for (District district : districts) {
            System.out.println(district.toString());
        }
    }

}
