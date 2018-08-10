/*
 * GoodsType.java
 * Copyright(C) 北京汽车易生活网络科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2018-08-06 Created
 */
package com.example.pojo;

import java.io.Serializable;

/**
 * 商品类型表
 *
 * @version 1.0 2018-08-06
 */
public class GoodsType implements Serializable {

    private String id;
    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品类型
     */
    private String goodsType;

    /**
     * 商品类型的创建时间,与商品的创建时间相同
     */
    private String createTime;

    public GoodsType() {
    }

    public GoodsType(String id, String goodsId, String goodsType, String createTime) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsType = goodsType;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id='" + id + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}