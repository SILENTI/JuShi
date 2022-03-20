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

    /**
     * 获取goods
     * @param id
     * @return
     */
    Goods selectGoodsByGid(Integer id);

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

    /**
     * 根据商品Id，改变商品库存
     * @param gid
     * @param newNum
     * @return
     */
    Integer updateGoodsNumByGid (Integer gid, Integer newNum);
}