package com.example.jushi.mapper;

import com.example.jushi.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    Order selectByPrimaryKey(Long id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

}