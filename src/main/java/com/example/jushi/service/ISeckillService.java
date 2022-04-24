package com.example.jushi.service;

import com.example.jushi.model.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.jushi.model.User;
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

    /**
     * 获取秒杀接口信息
     * @param user
     * @param sid
     * @return
     */
    String getSeckillPath (User user, Integer sid);

    /**
     * 判断秒杀接口是否符合条件
     * @param user
     * @param seckillPath
     * @return
     */
    boolean judgeSeckillPath (User user, Integer sid,String seckillPath);

}
