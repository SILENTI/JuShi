package com.example.jushi.mapper;

import com.example.jushi.model.Trolley;
import com.example.jushi.vo.TrolleyVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @author 居無何
 */
@Mapper
public interface TrolleyMapper {

    /**
     * 将商品添加到购物车
     * @param record
     * @return
     */
    Integer insertTrolley(Trolley record);

    /**
     * 根据aid修改，购物车中同商品的数量
     * @param tid
     * @param num
     * @param modifUser
     * @param modifTime
     * @return
     */
    Integer updateNumByTid(Integer tid, Integer num, String modifUser, Date modifTime);

    /**
     * 传递trolley，以更新num数据
     * @param trolley
     * @return
     */
    Integer updateNumForTrolleyByTid(Trolley trolley);

    /**
     * 查询当前商品是否已加入购物车
     * @param uid
     * @param gid
     * @return
     */
    Trolley selectTrolleyByUidAndGid (Integer uid,Integer gid);

    /**
     * 获取用户购物车列表
     * @param uid
     * @return
     */
    List<TrolleyVo> selectTrolleyVoByUid (Integer uid);

    /**
     * 购物车商品多选
     * @param tid
     * @return
     */
    List<TrolleyVo> selectTrolleyVo (Integer [] tid);


    int deleteByPrimaryKey(Integer tid);

    Trolley selectByPrimaryKey(Integer tid);

    List<Trolley> selectAll();

    int updateByPrimaryKey(Trolley record);
}