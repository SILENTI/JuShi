package com.example.jushi.service;

import com.example.jushi.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/3/6 9:22
 * Description: AddressService 测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private AddressService addressService;

    /**
     * 创建address，就是新建收货地址
     */
    @Test
    public void createAddress (){
        Address address = new Address();
        address.setUid(15);
        address.setName("梁朝伟");
        addressService.createAddress(15,"梁朝伟",address);
    }

}
