package com.example.jushi.mapper;

import com.example.jushi.model.Seckill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.jushi.vo.SeckillGoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
@Mapper
public interface SeckillMapper extends BaseMapper<Seckill> {

    /**
     * 根据sid获取秒杀信息
     * @param sid
     * @return
     */
    Seckill selectSeckillBySid (Integer sid);

    /**
     * 获取所有的Seckill信息
     * @return
     */
    List<Seckill> selectAllSeckill ();

    /**
     * 展示秒杀商品
     * @return
     */
    List<SeckillGoodsVo> selectAllSeckillGoodsVo ();

    /**
     * 根据分页，获取秒杀列表，
     * @param start
     * @param end
     * @return
     */
    List<Seckill> selectSeckillPage (Integer start, Integer end);

    /**
     * 下单成功后更改商品库存信息
     * @param sid
     * @param count
     * @return
     */
    Integer updateSeckillNumBySid (Integer sid, Integer count);

}
