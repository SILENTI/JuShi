package com.example.jushi.service;

import com.example.jushi.vo.TrolleyVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 居無何
 * date: 2022/3/10 19:48
 * Description:
 */
@Service
public interface TrolleyService {

    /**
     * 将商品加入购物车
     * @param uid
     * @param  num
     * @param gid
     * @param username
     */
    void addGoodsTrolley(Integer gid,Integer num,Integer uid,String username);

    /**
     * 用户购物车商品展示！！！
     * @param uid
     * @return
     */
    List<TrolleyVo> selectAllTrolleyVo (Integer uid);

}
