package com.example.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品类型,商品的属性,商品的计费模式和计价方式
 * Created by xjx on 2018/8/6.
 */
public class GoodsInformation implements Serializable {
    /**
     * 商品类型集合
     */
    private List<GoodsType> goodsTypeList;
    /**
     * 商品的属性集合
     */
    private List<String> goodsPropertyList;
    /**
     * 商品计费模式 0:按需;1:包年包月
     */
    private String billingPattern;
    /**
     * 商品的计价方式 0:单价;1:固定价格
     */
    private String priceType;

    public GoodsInformation() {
    }

    public GoodsInformation(List<GoodsType> goodsTypeList, List<String> goodsPropertyList, String billingPattern, String priceType) {
        this.goodsTypeList = goodsTypeList;
        this.goodsPropertyList = goodsPropertyList;
        this.billingPattern = billingPattern;
        this.priceType = priceType;
    }

    public List<GoodsType> getGoodsTypeList() {
        return goodsTypeList;
    }

    public void setGoodsTypeList(List<GoodsType> goodsTypeList) {
        this.goodsTypeList = goodsTypeList;
    }

    public List<String> getGoodsPropertyList() {
        return goodsPropertyList;
    }

    public void setGoodsPropertyList(List<String> goodsPropertyList) {
        this.goodsPropertyList = goodsPropertyList;
    }

    public String getBillingPattern() {
        return billingPattern;
    }

    public void setBillingPattern(String billingPattern) {
        this.billingPattern = billingPattern;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    @Override
    public String toString() {
        return "GoodsInformation{" +
                "goodsTypeList=" + goodsTypeList +
                ", goodsPropertyList=" + goodsPropertyList +
                ", billingPattern='" + billingPattern + '\'' +
                ", priceType='" + priceType + '\'' +
                '}';
    }
}
