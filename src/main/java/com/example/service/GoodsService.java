package com.example.service;

import com.example.pojo.GoodsPrice;
import com.example.pojo.GoodsProperty;
import com.example.utils.ShowVo;

import java.util.List;

/**
 * Created by xjx on 2018/8/6.
 */
public interface GoodsService {
    /**
     * 添加商品
     *
     * @param goodsProperty
     * @param showVo
     * @return
     */
    ShowVo saveGoods(GoodsProperty goodsProperty, ShowVo showVo);

    /**
     * 根据商品id查询商品类型,商品的属性,商品的计费模式和计价方式
     *
     * @param goodsId
     * @param showVo
     * @return
     */
    ShowVo queryGoodsInformation(String goodsId, ShowVo showVo);

    /**
     * 创建商品价格
     *
     * @param goodsPriceList
     * @param showVo
     * @return
     */
    ShowVo saveGoodsPrice(List<GoodsPrice> goodsPriceList, ShowVo showVo);

    /**
     * 删除商品
     *
     * @param ids
     * @param showVo
     * @return
     */
    ShowVo deleteGoods(String[] ids, ShowVo showVo);

    /**
     * 根据条件分页查询商品列表
     *
     * @param goodsProperty
     * @param page
     * @param rows
     * @param showVo
     * @return
     */
    ShowVo queryGoodsByPage(GoodsProperty goodsProperty, Integer page, Integer rows, ShowVo showVo);

    /**
     * 查看，查看某个商品的详情
     *
     * @param goodsProperty
     * @return
     */
    ShowVo queryGoodsPropertyById(GoodsProperty goodsProperty, ShowVo showVo);

    /**
     * 修改商品信息,商品价格除外
     *
     * @param goodsProperty
     * @return
     */
    ShowVo updateGoodsProperty(GoodsProperty goodsProperty,ShowVo showVo);
}
