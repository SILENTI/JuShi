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
public class IAddressServiceTests {

    @Autowired
    private IAddressService IAddressService;

    /**
     * 创建address，就是新建收货地址
     */
    @Test
    public void createAddress (){
        Address address = new Address();
        address.setUid(15);
        address.setName("梁朝伟");
        IAddressService.createAddress(15,"梁朝伟",address);
    }

    /**
     * 修改收货地址的默认地址
     */
    @Test
    public void changeAddressDefault (){
        IAddressService.changeAddressDefault(2,14,"鲁路修");
    }

    /**
     * 删除收货地址
     * */
    @Test
    public void deleteAddress (){
        IAddressService.deleteAddress(1,14,"断舍离");
    }

    /**
     * 更具aid获取address对象
     */
    @Test
    public void selectAddress(){
        Address address = IAddressService.selectAddressByAid(2,14);
        System.out.println(address.toString());
    }
}
