package com.example.service.serviceImpl;

import com.example.mapper.GoodsTypeMapper;
import com.example.pojo.GoodsType;
import com.example.service.GoodsTypeService;
import com.example.utils.ReturnData;
import com.example.utils.ShowVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xjx on 2018/8/6.
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    /**
     * 根据商品id查询商品类型
     *
     * @param goodsId
     * @return
     */
    public List<GoodsType> queryGoodsType(String goodsId) {
        GoodsType gt = new GoodsType();
        gt.setGoodsId(goodsId);
        List<GoodsType> goodsTypeList = goodsTypeMapper.queryGoodsType(gt);
        return goodsTypeList;
    }
}
