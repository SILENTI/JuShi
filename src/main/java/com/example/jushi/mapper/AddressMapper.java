package com.example.jushi.mapper;

import com.example.jushi.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 居無何
 * @Mapper 作用就是将xml文件和接口进行配对，然后生成Bean进行注册
 */
@Mapper

public interface AddressMapper {

    /**
     * 新增用户收货地址
     * @param address 传递Address数据
     * @return 返回修改的记录
     */
    Integer insert(Address address);

    /**
     * 查询用户含有多少条收货地址
     * @param uid
     * @return 返回用户收货地址的数量
     */
    Integer countByUid (Integer uid);

    /**
     * 根据用户id查询到用户的所有收货地址
     * @param uid
     * @return
     */
    List<Address> selectAllByUid (Integer uid);

    int deleteByPrimaryKey(Integer aid);

    Address selectByPrimaryKey(Integer aid);

    int updateByPrimaryKey(Address record);
}