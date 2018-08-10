package com.example.pojo;

import java.io.Serializable;

/**
 * 商品价格表
 *
 * @version 1.0 2018-08-06
 */
public class GoodsPrice implements Serializable {

    private String id;
    /**
     * 商品的属性和对应的价格的json
     */
    private String propertyPrice;

    /**
     * 商品的按需单价
     */
    private String priceNeed;

    /**
     * 商品的按月单价
     */
    private String priceMonth;

    /**
     * 商品的id
     */
    private String goodsId;

    /**
     * 商品类型id
     */
    private String goodsTypeId;

    /**
     * 商品类型名称
     */
    private String goodsTypeName;

    /**
     * 商品价格创建时间
     */
    private String createTime;

    /**
     * 商品价格修改时间
     */
    private String updateTime;

    public GoodsPrice() {
    }

    public GoodsPrice(String id, String propertyPrice, String priceNeed, String priceMonth, String goodsId, String goodsTypeId, String goodsTypeName, String createTime, String updateTime) {
        this.id = id;
        this.propertyPrice = propertyPrice;
        this.priceNeed = priceNeed;
        this.priceMonth = priceMonth;
        this.goodsId = goodsId;
        this.goodsTypeId = goodsTypeId;
        this.goodsTypeName = goodsTypeName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getPriceNeed() {
        return priceNeed;
    }

    public void setPriceNeed(String priceNeed) {
        this.priceNeed = priceNeed;
    }

    public String getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(String priceMonth) {
        this.priceMonth = priceMonth;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GoodsPrice{" +
                "id='" + id + '\'' +
                ", propertyPrice='" + propertyPrice + '\'' +
                ", priceNeed='" + priceNeed + '\'' +
                ", priceMonth='" + priceMonth + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", goodsTypeId='" + goodsTypeId + '\'' +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}