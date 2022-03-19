package com.example.jushi.service.impl;

import com.example.jushi.model.Seckill;
import com.example.jushi.mapper.SeckillMapper;
import com.example.jushi.service.ISeckillService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jushi.service.ex.SeckillGoodsOverTimeException;
import com.example.jushi.service.ex.SeckillGoodsSellOutException;
import com.example.jushi.vo.SeckillGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill> implements ISeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    /**
     * 秒杀商品展示
     * @return
     */
    @Override
    public List<SeckillGoodsVo> showSeckill() {
        return seckillMapper.selectAllSeckillGoodsVo();
    }

    @Override
    public void seckillJudge(Integer uid, Integer aid, Integer sid, Integer num, String userName) {

        Seckill seckill = seckillMapper.selectSeckillBySid(sid);
        //查询库存数量
        if (num>seckill.getCount()){
            //抛出异常-商品已售完
            throw new SeckillGoodsSellOutException("商品已销售完");
        }

        //限制用户购入商品数量-？？？？？？？

        //确认是否在当前秒杀范围内
        LocalDateTime localDateTime = LocalDateTime.now();

        if (!seckill.getStartTime().isBefore(localDateTime) || !seckill.getEndTime().isAfter(localDateTime)){
            //抛出异常
            throw new SeckillGoodsOverTimeException("秒杀商品已超出时间范围");
        }

    }
}
