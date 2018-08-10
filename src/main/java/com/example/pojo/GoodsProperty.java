package com.example.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表
 *
 * @version 1.0 2018-08-06
 */
public class GoodsProperty implements Serializable {

    private String id;
    /**
     * 商品组id
     */
    private String goodsGroupId;

    /**
     * 商品组名称
     */
    private String goodsGroupName;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 计费模式 0:按需;1:包年包月;2:按需和包年包月
     */
    private String billingPattern;

    /**
     * 区域id
     */
    private String regionId;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 商品属性
     */
    private String goodsProperty;

    /**
     * 商品的计价方式 0:单价;1:固定价格
     */
    private String priceType;

    /**
     * 商品的状态 0:未发布;1:上架;2:下架;
     */
    private String status;

    /**
     * 商品的创建时间
     */
    private String createTime;

    /**
     * 商品的修改时间
     */
    private String updateTime;

    /**
     * 商品的发布(上架)时间
     */
    private String upTime;

    /**
     * 商品的下架时间
     */
    private String downTime;

    /*扩展字段*/

    /**
     * 商品的类型，在创建商品时，商品的类型参数用此字段传递
     */
    private String goodsType;

    public GoodsProperty() {
    }

    public GoodsProperty(String id, String goodsGroupId, String goodsGroupName, String goodsName, String billingPattern, String regionId, String regionName, String goodsProperty, String priceType, String status, String createTime, String updateTime, String upTime, String downTime, String goodsType) {
        this.id = id;
        this.goodsGroupId = goodsGroupId;
        this.goodsGroupName = goodsGroupName;
        this.goodsName = goodsName;
        this.billingPattern = billingPattern;
        this.regionId = regionId;
        this.regionName = regionName;
        this.goodsProperty = goodsProperty;
        this.priceType = priceType;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.upTime = upTime;
        this.downTime = downTime;
        this.goodsType = goodsType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsGroupId() {
        return goodsGroupId;
    }

    public void setGoodsGroupId(String goodsGroupId) {
        this.goodsGroupId = goodsGroupId;
    }

    public String getGoodsGroupName() {
        return goodsGroupName;
    }

    public void setGoodsGroupName(String goodsGroupName) {
        this.goodsGroupName = goodsGroupName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBillingPattern() {
        return billingPattern;
    }

    public void setBillingPattern(String billingPattern) {
        this.billingPattern = billingPattern;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "GoodsProperty{" +
                "id='" + id + '\'' +
                ", goodsGroupId='" + goodsGroupId + '\'' +
                ", goodsGroupName='" + goodsGroupName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", billingPattern='" + billingPattern + '\'' +
                ", regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", goodsProperty='" + goodsProperty + '\'' +
                ", priceType='" + priceType + '\'' +
                ", status='" + status + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", upTime='" + upTime + '\'' +
                ", downTime='" + downTime + '\'' +
                ", goodsType='" + goodsType + '\'' +
                '}';
    }
}