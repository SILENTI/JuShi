package com.example.jushi.mapper;

import com.example.jushi.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/5 15:23
 * Description: 收货表测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 新增用户收货地址
     */
    @Test
    public void insertAddress (){
        Address address = new Address();
        address.setUid(14);
        address.setName("鲁路修");
        Integer record = addressMapper.insert(address);
        System.out.println("修改的记录："+record);
    }

    /**
     * 查询用户含有收货地址的数量
     */
    @Test
    public void countRecord(){

        int a = addressMapper.countByUid(14);
        System.out.println("用户含有的收货地址记录：" + a);
    }

    /**
     * 查询用户所含的所有地址信息
     */
    @Test
    public void selectAllByUid (){
        List<Address> addresses = addressMapper.selectAllByUid(14);
        for (Address address : addresses) {
            System.out.println(address.toString());
        }
    }

}
