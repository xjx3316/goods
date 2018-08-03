package com.example.mapper;

import com.example.pojo.GoodsGroup;

import java.util.List;

public interface GoodsGroupMapper {
    /**
     * 添加商品组
     *
     * @param goodsGroup
     */
    Integer saveGoodsGroup(GoodsGroup goodsGroup);

    /**
     * 删除商品组
     *
     * @param goodsGroup
     * @return
     */
    Integer deleteGoodsGroup(GoodsGroup goodsGroup);

    /**
     * 修改商品组
     *
     * @param goodsGroup
     * @return
     */
    Integer updateGoodsGroup(GoodsGroup goodsGroup);

    /**
     * 查询商品组
     *
     * @param goodsGroup
     * @return
     */
    List<GoodsGroup> queryGoodsGroup(GoodsGroup goodsGroup);

    /**
     * 根据id查询产品组
     *
     * @param goodsGroup
     * @return
     */
    GoodsGroup queryGoodsGroupById(GoodsGroup goodsGroup);
}