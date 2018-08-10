package com.example.mapper;

import com.example.pojo.GoodsPrice;

import java.util.List;

public interface GoodsPriceMapper {
    /**
     * 创建商品价格
     *
     * @param goodsPrice
     * @return
     */
    Integer saveGoodsPrice(GoodsPrice goodsPrice);

    /**
     * 查询商品价格对象
     * @param goodsPrice
     * @return
     */
    List<GoodsPrice> queryGoodsPrice(GoodsPrice goodsPrice);

    /**
     * 根据商品id删除商品对应的价格
     * @param goodsPropertyId
     */
    void deleteGoodsPrice(String goodsPropertyId);
}