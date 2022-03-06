package com.example.jushi.service;

import com.example.jushi.model.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 20:03
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictServiceTests {

    @Autowired
    private DistrictService districtService;

    /**
     * 获取地址
     */
    @Test
    public void findDistrict (){
        List<District> districtList = districtService.findDistrict("86");
        for (District district : districtList) {
            System.out.println(district.toString());
        }
    }

}
