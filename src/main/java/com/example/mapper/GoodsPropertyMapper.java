package com.example.mapper;

import com.example.pojo.GoodsPrice;
import com.example.pojo.GoodsProperty;

import java.util.List;

public interface GoodsPropertyMapper {
    /**
     * 添加商品
     *
     * @param goodsProperty
     * @return
     */
    Integer saveGoods(GoodsProperty goodsProperty);

    /**
     * 查询商品
     *
     * @param goodsProperty
     * @return
     */
    List<GoodsProperty> queryGoodsProperty(GoodsProperty goodsProperty);

    /**
     * 根据主键id查询商品对象
     *
     * @param goodsId
     * @return
     */
    GoodsProperty queryGoodsPropertyById(String goodsId);

    /**
     * 删除商品
     *
     * @param goodsProperty
     * @return
     */
    Integer deleteGoods(GoodsProperty goodsProperty);

    /**
     * 修改商品信息,商品价格除外
     *
     * @param goodsProperty
     * @return
     */
    Integer updateGoodsProperty(GoodsProperty goodsProperty);
}