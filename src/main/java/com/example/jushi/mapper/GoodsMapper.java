package com.example.jushi.mapper;

import com.example.jushi.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface GoodsMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    Goods selectByPrimaryKey(Integer id);

    /**
     * 展示所用的商品，更具商品的销售量
     * @return
     */
    List<Goods> selectAllGoods();

    /**
     * 根据商品id查询，该商品的单价
     * @param gid
     * @return
     */
    BigDecimal selectPriceByGid (Integer gid);

    int updateByPrimaryKey(Goods record);
}