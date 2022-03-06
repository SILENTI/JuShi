package com.example.jushi.service;

import com.example.jushi.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/5 16:49
 * Description:
 */
@Service
public interface AddressService {

    /**
     * 新建收货地址
     * @param uid
     * @param username 用户名
     * @param address 包含收货地址的实体对象
     */
    void createAddress (Integer uid, String username, Address address);

    /**
     * 更具用户id 查询到所有的address
     * @param uid
     * @return
     */
    List<Address> findAllAddress (Integer uid);
}
