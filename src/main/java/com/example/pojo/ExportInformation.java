package com.example.pojo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by xjx on 2018/8/10.
 */
public class ExportInformation implements Serializable {
    private String goodsType;//接收此商品的类型
    private String property;//接收需要显示的excel列属性
    private String propertyPrice;//接收数据

    public ExportInformation() {
    }

    public ExportInformation(String goodsType, String property, String propertyPrice) {
        this.goodsType = goodsType;
        this.property = property;
        this.propertyPrice = propertyPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    @Override
    public String toString() {
        return "ExportInformation{" +
                "goodsType='" + goodsType + '\'' +
                ", property='" + property + '\'' +
                ", propertyPrice='" + propertyPrice + '\'' +
                '}';
    }
}
