package com.example.jushi.controller;

import com.example.jushi.model.User;
import com.example.jushi.service.ITrolleyService;
import com.example.jushi.util.JsonResult;
import com.example.jushi.vo.TrolleyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 22:41
 * Description:
 */
@RestController
@RequestMapping("/jushi/goods")
public class TrolleyController {

    @Autowired
    private ITrolleyService ITrolleyService;

    /**
     * 用户添加商品到购物车
     * @param gid
     * @param num
     * @param httpSession
     * @return
     */
    @RequestMapping("/add_goods_trolley")
    public JsonResult<Void> addGoodsTrolley (Integer gid,Integer num, HttpSession httpSession){

        User user = (User) httpSession.getAttribute("user");

        ITrolleyService.addGoodsTrolley(gid,num,user.getUid(), user.getUsername());

        return new JsonResult<Void>("添加成功");
    }

    /**
     * 购物车展示，商品所有的商品展示
     * @param session
     * @return
     */
    @RequestMapping("/show_trolleys")
    public JsonResult<List<TrolleyVo>> showAllTrolley (HttpSession session){

        User user = (User) session.getAttribute("user");

        List<TrolleyVo> trolleyVos = ITrolleyService.selectAllTrolleyVo(user.getUid());

        return new JsonResult<>(trolleyVos,"数据获取成功");
    }

    /**
     * 获取所有的已勾选得到购物车商品
     * @param tid
     * @return
     */
    @RequestMapping("/get_select_trolley")
    public JsonResult<List<TrolleyVo>> getTrolleyVo (Integer [] tid){
        List<TrolleyVo> trolleyVos = ITrolleyService.selectTrolleyVoByTid(tid);
        return new JsonResult<List<TrolleyVo>>(trolleyVos,"数据获取成功");
    }
}
