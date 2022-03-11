package com.example.jushi.service;

import org.springframework.stereotype.Service;

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

}
