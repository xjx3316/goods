package com.example.mapper;

import com.example.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeMapper {
    /**
     * 添加商品类型
     *
     * @param goodsType
     * @return
     */
    Integer saveGoodsType(GoodsType goodsType);

    /**
     * 查询商品类型
     *
     * @param goodsType
     * @return
     */
    List<GoodsType> queryGoodsType(GoodsType goodsType);

    /**
     * 通过商品id删除属于此商品的类型
     * @param goodsPropertyId
     */
    void deleteGoodsType(String goodsPropertyId);
}