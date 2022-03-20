package com.example.jushi.service;

import com.example.jushi.model.Order;
import com.example.jushi.model.OrderItem;
import com.example.jushi.model.Trolley;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/13 17:27
 * Description: 订单相关业务层
 */
@Service
public interface IOrderService {

    /**
     * 创建订单信息-就是从购物车多选下单
     * @param uid
     * @param aid
     * @param tid
     * @param userName
     * @return
     */
    Order createOrderByTrolley (Integer uid, Integer aid, Integer [] tid, String userName);

    /**
     * 根据商品直接下单
     * @param uid
     * @param aid
     * @param gid
     * @param num 下单商品数量
     * @param username
     * @return
     */
    Order createOrderByGoods (Integer uid, Integer aid, Integer gid, Integer num, String username);

    /**
     * 秒杀商品下单
     * @param uid
     * @param aid
     * @param sid
     * @param num
     * @param userName
     * @return
     */
    Order creatOrderBySeckill (Integer uid, Integer aid, Integer sid, Integer num, String userName);

    /**
     * 修改商品库存
     * @param gid
     * @param count
     * @return
     */
    void modifyGoodsCount (Integer gid, Integer count);

    /**
     * 修改秒杀商品库存
     * @param sid
     * @param count
     */
    void modifySeckillCount (Integer sid, Integer count);

    /**
     * 新增orderItem数据
     * @param orderItem
     */
    void createOrderItem (OrderItem orderItem);


}
