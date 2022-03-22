package com.example.jushi.mapper;

import com.example.jushi.model.OrderItem;
import com.example.jushi.model.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface OrderItemMapper {

    /**
     * 新增OrderItem数据
     * @param record
     * @return
     */
    Integer insertOrderItem(OrderItem record);

    /**
     * 根据uid和gid查询订单信息
     * @param uid
     * @param gid
     * @return
     */
    OrderItem selectSeckillByUIdAndGid (Integer uid, Integer gid);
}