package com.example.jushi.vo;

import lombok.Data;

import java.math.BigDecimal;
/**
 * @author 居無何
 * 商品列表展示
 * */
@Data
public class GoodsVo {

    private Integer gId;

    private String gName;

    private String gImg;

    private String gType;

    private BigDecimal gPrice;

    private Integer gStock;
}
