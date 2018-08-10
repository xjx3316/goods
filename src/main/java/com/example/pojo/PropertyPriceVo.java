package com.example.pojo;

import java.io.Serializable;

/**
 * Created by xjx on 2018/8/9.
 */
public class PropertyPriceVo implements Serializable {
    private String propertyPrice;//商品属性和对应的属性值
    private String priceNeed;//按需价格
    private String priceMonth;//包年包月价格

    public PropertyPriceVo() {
    }

    public PropertyPriceVo(String propertyPrice, String priceNeed, String priceMonth) {
        this.propertyPrice = propertyPrice;
        this.priceNeed = priceNeed;
        this.priceMonth = priceMonth;
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

    @Override
    public String toString() {
        return "PropertyPriceVo{" +
                ", propertyPrice='" + propertyPrice + '\'' +
                ", priceNeed='" + priceNeed + '\'' +
                ", priceMonth='" + priceMonth + '\'' +
                '}';
    }
}
