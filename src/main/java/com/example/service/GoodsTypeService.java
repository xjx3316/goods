package com.example.service;

import com.example.pojo.GoodsType;
import com.example.utils.ShowVo;

import java.util.List;

/**
 * Created by xjx on 2018/8/6.
 */
public interface GoodsTypeService {
    /**
     * 根据商品id查询商品类型
     *
     * @param goodsId
     * @return
     */
    List<GoodsType> queryGoodsType(String goodsId);
}
