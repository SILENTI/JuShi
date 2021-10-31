package com.example.jushi.mapper;

import com.example.jushi.model.Goods;
import com.example.jushi.model.SeckillData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface GoodsMapper {

    /**
     * 根据id，查询指定商品的信息
     * @param id
     * @return Goods
     * */
    Goods selectByPrimaryKey(Integer id);

    /**
     * 查询到所有的商品信息
     * @return List<Goods>
     * */
    List<Goods> selectAll();

//    int deleteByPrimaryKey(Integer id);
//
//    int insert(Goods record);
//
//    int updateByPrimaryKey(Goods record);


}