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
public interface IAddressService {

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

    /**
     * 设置默认收货地址
     * @param aid
     * @param uid
     * @param username
     */
    void changeAddressDefault (Integer aid , Integer uid,String username);

    /**
     * 删除收货地址
     * @param aid
     * @param uid
     * @param username
     */
    void deleteAddress (Integer aid,Integer uid,String username);

    /**
     * 根据aid查询到address信息
     * @param aid
     * @param uid
     * @return
     */
    Address selectAddressByAid (Integer aid,Integer uid);

}
