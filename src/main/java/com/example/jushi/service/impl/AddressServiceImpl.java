package com.example.jushi.service.impl;

import com.example.jushi.mapper.AddressMapper;
import com.example.jushi.model.Address;
import com.example.jushi.service.AddressService;
import com.example.jushi.service.ex.AddressNotExistException;
import com.example.jushi.service.ex.AddressOutOfRangeException;
import com.example.jushi.service.ex.UpdateException;
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
public class AddressServiceImpl implements AddressService {

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

        return addresses;
    }


}
