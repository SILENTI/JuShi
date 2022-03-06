package com.example.jushi.controller;


import com.example.jushi.model.Address;
import com.example.jushi.model.User;
import com.example.jushi.service.AddressService;
import com.example.jushi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/6 9:56
 * Description: 用户收货地址相关
 */
@RestController
@RequestMapping("/jushi/user")
public class AddressController  {

    @Autowired
    private AddressService addressService;

    /**
     * 新建用户收货地址
     * @param address
     * @param session
     * @return 返回新增后的收货地址/所有的收货地址
     */
    @RequestMapping("/create_address")
    public JsonResult<List<Address>> createAddress (Address address, HttpSession session){

        //获取Session中User
        User user = (User) session.getAttribute("user");

        //先将传递的信息传递个service层
        addressService.createAddress(user.getUid(),user.getUsername(),address);

        //若以上正常，未抛出异常，则进行查询
        List<Address> addresses = addressService.findAllAddress(user.getUid());

        return new JsonResult<List<Address>>(addresses,"收货地址新建成功");
    }

}