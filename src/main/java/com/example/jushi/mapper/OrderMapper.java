package com.example.jushi.mapper;

import com.example.jushi.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface OrderMapper {

    /**
     * 数据新增
     * @param record
     * @return
     */
    Integer insertOrder(Order record);

    /**
     * 查询order对象信息
     * @param oid
     * @return
     */
    Order selectOrderByAid(Integer oid);

    int deleteByPrimaryKey(Integer oid);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}