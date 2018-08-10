package com.example.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 例子
 * 当主机的类型为标准型时，各种配置的属性和价格
 * Created by xjx on 2018/8/9.
 */
public class GoodsTypePriceVo implements Serializable {
    private String goodsTypeId;//商品类型主键id
    private String goodsTypeName;//商品类型
    private List<PropertyPriceVo> propertyPriceVoList;//同一个商品类型下的全部属性值和对应的价格

    public GoodsTypePriceVo() {
    }

    public GoodsTypePriceVo(String goodsTypeId, String goodsTypeName, List<PropertyPriceVo> propertyPriceVoList) {
        this.goodsTypeId = goodsTypeId;
        this.goodsTypeName = goodsTypeName;
        this.propertyPriceVoList = propertyPriceVoList;
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

    public List<PropertyPriceVo> getPropertyPriceVoList() {
        return propertyPriceVoList;
    }

    public void setPropertyPriceVoList(List<PropertyPriceVo> propertyPriceVoList) {
        this.propertyPriceVoList = propertyPriceVoList;
    }

    @Override
    public String toString() {
        return "GoodsTypePriceVo{" +
                "goodsTypeId='" + goodsTypeId + '\'' +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                ", propertyPriceVoList=" + propertyPriceVoList +
                '}';
    }
}
