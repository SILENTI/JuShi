package com.example.jushi.service.impl;

import com.example.jushi.mapper.TrolleyMapper;
import com.example.jushi.model.Trolley;
import com.example.jushi.service.TrolleyService;
import com.example.jushi.service.ex.InsertException;
import com.example.jushi.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 居無何
 * date: 2022/3/10 19:49
 * Description:
 */
@Service
public class TrolleyServiceImpl implements TrolleyService {

    @Autowired
    private TrolleyMapper trolleyMapper;

    /**
     * 传递uid，gid，username组成 Trolley对象
     * @param uid
     * @param num
     * @param gid
     * @param username
     */
    @Override
    public void addGoodsTrolley(Integer gid,Integer num,Integer uid,String username){

        //组装Trolley对象
        Trolley trolley = new Trolley();
        trolley.setUid(uid);
        trolley.setGid(gid);
        trolley.setNum(num);
        trolley.setCreatedUser(username);
        trolley.setCreateTime(new Date());
        trolley.setModifUser(username);
        trolley.setModifTime(new Date());

        //查询当前商品，是否已加入购物车
        Trolley findTrolley = trolleyMapper.selectTrolleyByUidAndGid(uid, gid);
        //若商品未加入购物车，则新增数据操作
        if (findTrolley == null){
            Integer record = trolleyMapper.insertTrolley(trolley);
            if (record == null){
                throw new InsertException("遇到未知错误，数据插入失败");
            }
        }

        //若商品已加入购物车，则修改该商品的数量
        if (findTrolley != null){

            trolley.setNum(trolley.getNum()+ findTrolley.getNum());
            trolley.setTid(findTrolley.getTid());

          Integer record = trolleyMapper.updateNumByTid(findTrolley.getTid(), findTrolley.getNum()+num,username,new Date() );
//            Integer record = trolleyMapper.updateNumForTrolleyByTid(trolley);
            if (record == null){
                throw new UpdateException("遇到未知错误，数据更新失败");
            }
        }




    }

}
