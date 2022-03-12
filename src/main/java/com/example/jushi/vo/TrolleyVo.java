package com.example.jushi.vo;

import java.math.BigDecimal;

/**
 * @author 居無何
 * date: 2022/3/11 21:32
 * Description: 购物车展示
 */
public class TrolleyVo {

    private Integer uid;

    private Integer gid;

    private Integer tid;

    private BigDecimal price;

    private Integer num;

    private String goodsName;

    private BigDecimal realPrice;

    private String goodsDescribe;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public String getgoodsDescribe() {
        return goodsDescribe;
    }

    public void setgoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    @Override
    public String toString() {
        return "TrolleyVo{" +
                "uid=" + uid +
                ", gid=" + gid +
                ", tid=" + tid +
                ", price=" + price +
                ", num=" + num +
                ", goodsName='" + goodsName + '\'' +
                ", realPrice=" + realPrice +
                ", goodsDescribe='" + goodsDescribe + '\'' +
                '}';
    }
}
