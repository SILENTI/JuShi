package com.example.jushi.service.impl;

import com.example.jushi.mapper.AddressMapper;
import com.example.jushi.model.Address;
import com.example.jushi.service.IAddressService;
import com.example.jushi.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/5 16:53
 * Description:
 */
@Service
public class AddressServiceImpl implements IAddressService {

    private  Integer Address_Max = 20;

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 新建收货地址
     * @param uid
     * @param username 用户名
     * @param address 包含收货地址的实体对象
     */
    @Override
    public void createAddress(Integer uid, String username, Address address) {

        //先查询数据库，确认用户已有货地址
        Integer record = addressMapper.countByUid(uid);

        //如果查询到的信息为0，则将当前新建的地址设置为默认地址 默认为1
        if (record == 0 ){
            address.setIsDefault(1);
        } else if ( record >= Address_Max ){
            throw new AddressOutOfRangeException("新增地址数据超出范围如");
        }

        //将用户的id和修改用户级日志相关填充
        address.setUid(uid);
        address.setCreateUser(username);
        address.setCreateTime(new Date());
        address.setModifUser(username);
        address.setModifTime(new Date());

        //若以上未出现问题，将数据传递到dao层，进行数据的更新
        Integer updateRecord = addressMapper.insert(address);

        //若更更新的数据 updateRecord !=1 数据更新失败
        if (updateRecord != 1){
            throw new UpdateException("遇到未知错误，数据更新失败");
        }
    }

    /**
     * 根据用户id查找到所有的用户信息
     * @param uid
     * @return 当前用户含有的所有收货地址对象
     */
    @Override
    public List<Address> findAllAddress (Integer uid){

        //当查询到address为null，则抛出异常
        List<Address> addresses = addressMapper.selectAllByUid(uid);
        if (addresses == null){
            throw new AddressNotExistException("查询到的Address信息不存在");
        }

        //除去一些不重要的信息，或者创建Vo实体对象，将Address实体对象转化为Vo对象
        for (Address address : addresses) {
            address.setCreateUser(null);
            address.setCreateTime(null);
            address.setModifUser(null);
            address.setModifTime(null);
        }

        return addresses;
    }

    /**
     * 设置默认收货地址
     * @param aid
     * @param uid
     * @param username
     */
    @Override
    public void changeAddressDefault(Integer aid, Integer uid,String username) {

        //查询当前用户是否有收货地址
        Address address = addressMapper.selectAddressByAid(aid);
        if (address == null){
            throw new AddressNotExistException("当前收货地址不存在");
        }

        //确认所查询到收货地址的用户与传递的用户信息是否一致
        if (!address.getUid().equals(uid)){
            throw new AddressAccessViolationException("非法访问");
        }

        //修改默认收货地址
        Integer record_not = addressMapper.updateAddressDefaultAllByUid(uid);

        if (record_not == 0) {
            throw new UpdateException("出现未知错误，数据更新失败");
        }

        Integer record_is = addressMapper.updateAddressDefaultByAid(aid,username,new Date());

        if (record_not == 0) {
            throw new UpdateException("出现未知错误，数据更新失败");
        }
    }

    /**
     * 删除收货地址
     * @param aid
     * @param uid
     * @param username
     */
    @Override
    public void deleteAddress(Integer aid, Integer uid, String username) {

        //更具aid查询当前收货地址是否存在，并判断uid是否相同
        Address address = addressMapper.selectAddressByAid(aid);

        if (address == null){
            throw new AddressNotExistException("该收货地址不存在");
        }
        if (!address.getUid().equals(uid)){
             throw new AddressAccessViolationException("非法访问");
        }

        //删除收货地址
        Integer record_delete = addressMapper.deleteAddressByAid(aid);
        if (record_delete != 1){
            throw new DeleteException("数据删除出现未知错误");
        }

        //确认所当前用户所剩下的收货地址
        Integer addressNum = addressMapper.countByUid(uid);
        if (addressNum == 0){
            return;
        }

        //若删除的为默认收货地址，将最近修改的地址为默认地址
        if (!address.getIsDefault().equals(1)){
            Integer newDefaultAddress = addressMapper.selectLatestModifyAddressByUid(uid);
            Integer record = addressMapper.updateAddressDefaultByAid(newDefaultAddress,username,new Date());
            if (record == null ) {
                throw new UpdateException("遇到未知错误，数据更新失败");
            }
        }
    }

    /**
     * 根据aid查询到address信息
     * @param aid
     * @param uid
     * @return
     */
    @Override
    public Address selectAddressByAid(Integer aid,Integer uid) {

        Address address = addressMapper.selectAddressByAid(aid);

        if (!address.getUid().equals(uid)){
            throw new AddressAccessViolationException("非法访问");
        }

        return address;
    }

}
