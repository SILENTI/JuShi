package com.example.jushi.mapper;

import com.example.jushi.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
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

    /**
     * 根据用户名查询到当前用户下的所有的收货地址，并将其设置为非默认地址
     * @param uid
     * @return 返回修改的记录
     */
    Integer updateAddressDefaultAllByUid (Integer uid);

    /**
     * 根据aid查询到收货地址信息，并将其设置为默认地址
     * @parem aid
     * @param modifUser
     * @param modifTime
     * @return 返回修改的记录
     */
    Integer updateAddressDefaultByAid (Integer aid, String modifUser, Date modifTime);

    /**
     * 删除收货地址根据aid
     * @param aid
     * @return
     */
    Integer deleteAddressByAid(Integer aid);

    /**
     * 更具aid查询当前收货地址
     * @param aid
     * @return address 实体对象
     */
    Address selectAddressByAid(Integer aid);

    /**
     * 根据用户id获取最新修改的收货地址
     * @param uid
     * @return
     */
    Integer selectLatestModifyAddressByUid (Integer uid);

    /**
     * @param record
     * @return
     */
    int updateByPrimaryKey(Address record);
}