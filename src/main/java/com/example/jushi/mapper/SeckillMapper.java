package com.example.jushi.mapper;

import com.example.jushi.model.Seckill;
import java.util.List;

public interface SeckillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Seckill record);

    Seckill selectByPrimaryKey(Long id);

    List<Seckill> selectAll();

    int updateByPrimaryKey(Seckill record);
}