package com.example.jushi.service;

import com.example.jushi.model.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.jushi.vo.SeckillGoodsVo;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 居無何
 * @since 2022/03/19
 */
public interface ISeckillService extends IService<Seckill> {

    /**
     * 秒杀商品
     * @return
     */
    List<SeckillGoodsVo> showSeckill ();

    /**
     * 秒杀商品下单判断
     * @param uid
     * @param aid
     * @param sid
     * @param num
     * @param userName
     */
    void seckillJudge (Integer uid, Integer aid, Integer sid, Integer num, String userName );



}
