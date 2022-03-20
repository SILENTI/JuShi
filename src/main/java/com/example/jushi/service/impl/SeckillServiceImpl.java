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

    /**
     * 秒杀条件判断
     * @param uid 用户ID
     * @param aid 收货地址ID
     * @param sid 秒杀ID
     * @param num
     * @param userName
     */
    @Override
    public void seckillJudge(Integer uid, Integer aid, Integer sid, Integer num, String userName) {

        Seckill seckill = seckillMapper.selectSeckillBySid(sid);
        //查询库存数量
        if (num>seckill.getCount()){
            //抛出异常-商品已售完
            throw new SeckillGoodsSellOutException("商品已销售完");
        }

        //限制用户购入商品数量——>去订单表找寻答案！！！！！
        // 通过sid查询到秒杀商品表，获取到gid，
        // 然后根据uid和gid所得到的订单信息，若查询不到直接让用户下单
        // 若查询得到订单信息，根据d查询到订单创建时间，与秒杀订单开始与结束，判断是否在这段时间之内，若在其之中则抛出异常，


        //确认是否在当前秒杀范围内
        LocalDateTime localDateTime = LocalDateTime.now();

        if (!seckill.getStartTime().isBefore(localDateTime) || !seckill.getEndTime().isAfter(localDateTime)){
            //抛出异常
            throw new SeckillGoodsOverTimeException("秒杀商品已超出时间范围");
        }

    }
}
