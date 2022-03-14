package com.example.jushi.mapper;

import com.example.jushi.model.OrderItem;
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

    int deleteByPrimaryKey(Integer id);

    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}