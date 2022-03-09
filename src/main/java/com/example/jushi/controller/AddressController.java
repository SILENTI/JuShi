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

    /**
     * 根据uid获取该用户所有address
     * @param session
     * @return
     */
    @RequestMapping("/show_address")
    public JsonResult<List<Address>> showAddress ( HttpSession session ){

        //获取uid
        User user = (User) session.getAttribute("user");
        Integer uid = user.getUid();

        //获取address列表
        List<Address> addresses = addressService.findAllAddress(uid);

       return new JsonResult<List<Address>>(addresses,"当前用户收货地址获取成功");
    }

    /**
     * 修改默认收货地址
     * @param aid
     * @param session
     * @return
     */
    @RequestMapping("/change_default_address")
    public JsonResult<Void> changeDefaultAddress (Integer aid , HttpSession session){

        //获取user对象
        User user = (User) session.getAttribute("user");

        //传递数据
        addressService.changeAddressDefault(aid,user.getUid(), user.getUsername());

        return new JsonResult<>("默认地址修改成功");
    }

    /**
     * 删除收货地址
     * @param aid
     * @param session
     * @return
     */
    @RequestMapping("/delete_address")
    public JsonResult<Void> deleteAddress (Integer aid, HttpSession session){

        //获取user对象
        User user = (User) session.getAttribute("user");


        //调用addressService 方法
        addressService.deleteAddress(aid,user.getUid(),user.getUsername());

        return new JsonResult<>("收货删除成功");
    }

}
