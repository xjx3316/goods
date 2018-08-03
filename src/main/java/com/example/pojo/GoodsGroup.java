package com.example.pojo;

import java.io.Serializable;

/**
 * Created by xjx on 2018/8/3.
 */
public class GoodsGroup implements Serializable {

    private String id;
    /** 商品组名称 */
    private String goodsGroupName;

    /** 商品组描述 */
    private String goodsGroupDescribe;

    /** 创建时间 */
    private String createTime;

    /** 修改时间 */
    private String updateTime;

    public GoodsGroup() {
    }

    public String getId() {
        return id;
    }

    public String getGoodsGroupName() {
        return goodsGroupName;
    }

    public String getGoodsGroupDescribe() {
        return goodsGroupDescribe;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGoodsGroupName(String goodsGroupName) {
        this.goodsGroupName = goodsGroupName;
    }

    public void setGoodsGroupDescribe(String goodsGroupDescribe) {
        this.goodsGroupDescribe = goodsGroupDescribe;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GoodsGroup{" +
                "id='" + id + '\'' +
                ", goodsGroupName='" + goodsGroupName + '\'' +
                ", goodsGroupDescribe='" + goodsGroupDescribe + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
