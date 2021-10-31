package com.example.jushi.mapper;

import com.example.jushi.model.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface SeckillMapper {

    /**
     * 更具gId，查询到秒杀商品的信息
     * @param gId Integer
     * @return Seckill 秒杀商品的详细信息
     * */
    Seckill selectByPrimaryKey(Integer gId);

//    int deleteByPrimaryKey(Long id);
//
//    int insert(Seckill record);
//
//    List<Seckill> selectAll();
//
//    int updateByPrimaryKey(Seckill record);
}