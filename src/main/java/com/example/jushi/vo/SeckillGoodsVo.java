package com.example.jushi.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.jushi.model.Goods;
import com.example.jushi.model.Seckill;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 居無何
 * date: 2022/3/19 14:25
 * Description:
 */
public class SeckillGoodsVo extends Seckill {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("秒杀ID")
    @TableId(value = "sid", type = IdType.AUTO)
    private Integer sid;

    @ApiModelProperty("商品ID")
    private Integer gid;

    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;

    @ApiModelProperty("秒杀价格")
    private BigDecimal price;

    @ApiModelProperty("商品库存")
    private Integer count;

    private String gName;

    private String gType;

    private BigDecimal gPrice;

    private String gImg;

    private Integer gSales;

    private String gDescribe;

    private Integer gState;

    @Override
    public Integer getSid() {
        return sid;
    }

    @Override
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public Integer getGid() {
        return gid;
    }

    @Override
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Integer getCount() {
        return count;
    }

    @Override
    public void setCount(Integer count) {
        this.count = count;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public BigDecimal getgPrice() {
        return gPrice;
    }

    public void setgPrice(BigDecimal gPrice) {
        this.gPrice = gPrice;
    }

    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }

    public Integer getgSales() {
        return gSales;
    }

    public void setgSales(Integer gSales) {
        this.gSales = gSales;
    }

    public String getgDescribe() {
        return gDescribe;
    }

    public void setgDescribe(String gDescribe) {
        this.gDescribe = gDescribe;
    }

    public Integer getgState() {
        return gState;
    }

    public void setgState(Integer gState) {
        this.gState = gState;
    }

    @Override
    public String toString() {
        return "SeckillGoodsVo{" +
                "sid=" + sid +
                ", gid=" + gid +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", count=" + count +
                ", gName='" + gName + '\'' +
                ", gType='" + gType + '\'' +
                ", gPrice=" + gPrice +
                ", gImg='" + gImg + '\'' +
                ", gSales=" + gSales +
                ", gDescribe='" + gDescribe + '\'' +
                ", gState=" + gState +
                '}';
    }
}
