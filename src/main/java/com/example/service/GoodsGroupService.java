package com.example.service;

import com.example.pojo.GoodsGroup;
import com.example.utils.ShowVo;

/**
 * Created by xjx on 2018/8/3.
 */
public interface GoodsGroupService {
    /**
     * 添加商品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    ShowVo saveGoodsGroup(GoodsGroup goodsGroup, ShowVo showVo);

    /**
     * 删除商品组
     *
     * @param goodsGroupIds
     * @param showVo
     * @return
     */
    ShowVo deleteGoodsGroup(String[] goodsGroupIds, ShowVo showVo);

    /**
     * 修改商品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    ShowVo updateGoodsGroup(GoodsGroup goodsGroup, ShowVo showVo);

    /**
     * 查询产品组
     * page=0&&rows=0不分页，否则分页
     *
     * @param page
     * @param rows
     * @param showVo
     * @return
     */
    ShowVo queryGoodsGroupByPage(Integer page, Integer rows, GoodsGroup goodsGroup, ShowVo showVo);

    /**
     * 根据id查询产品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    ShowVo queryGoodsGroupById(GoodsGroup goodsGroup, ShowVo showVo);
}
