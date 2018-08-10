package com.example.service.serviceImpl;

import com.example.mapper.GoodsPriceMapper;
import com.example.mapper.GoodsPropertyMapper;
import com.example.mapper.GoodsTypeMapper;
import com.example.pojo.*;
import com.example.service.GoodsService;
import com.example.utils.DateUtils;
import com.example.utils.ReturnData;
import com.example.utils.ShowVo;
import com.example.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xjx on 2018/8/6.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    private static final Logger LOG = Logger.getLogger(GoodsServiceImpl.class);
    @Autowired
    private GoodsPropertyMapper goodsPropertyMapper;
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Autowired
    private GoodsPriceMapper goodsPriceMapper;

    /**
     * 添加商品
     *
     * @param goodsProperty
     * @param showVo
     * @return
     */
    public ShowVo saveGoods(GoodsProperty goodsProperty, ShowVo showVo) {
        String id = UuidUtils.get32UUID();//商品id
        String time = DateUtils.getnow();//创建时间
        goodsProperty.setId(id);
        goodsProperty.setCreateTime(time);
        goodsProperty.setStatus("0");//商品的状态 0:未发布;1:上架;2:下架;
        Integer i = goodsPropertyMapper.saveGoods(goodsProperty);
        if (i != 1) {
            showVo.setCode(ReturnData.GOODS_SAVE_FAIL.getCode());
            showVo.setMessage(ReturnData.GOODS_SAVE_FAIL.getMessage());
            return showVo;
        }
        //添加商品类型
        String[] split = goodsProperty.getGoodsType().split(",");
        for (String type : split) {
            GoodsType goodsType = new GoodsType();
            goodsType.setId(UuidUtils.get32UUID());
            goodsType.setGoodsId(id);
            goodsType.setGoodsType(type);
            goodsType.setCreateTime(time);
            Integer integer = goodsTypeMapper.saveGoodsType(goodsType);
            if (integer != 1) {
                showVo.setCode(ReturnData.GOODS_TYPE_SAVE_FAIL.getCode());
                showVo.setMessage(ReturnData.GOODS_TYPE_SAVE_FAIL.getMessage());
                return showVo;
            }
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 根据商品id查询商品类型,商品的属性,商品的计费模式和计价方式
     *
     * @param goodsId
     * @param showVo
     * @return
     */
    public ShowVo queryGoodsInformation(String goodsId, ShowVo showVo) {
        GoodsInformation goodsInformation = new GoodsInformation();
        //商品类型
        GoodsType goodsType = new GoodsType();
        goodsType.setGoodsId(goodsId);
        List<GoodsType> goodsTypeList = goodsTypeMapper.queryGoodsType(goodsType);

        //商品的属性,计费模式和计价方式
        GoodsProperty goodsProperty = goodsPropertyMapper.queryGoodsPropertyById(goodsId);
        String[] properties = goodsProperty.getGoodsProperty().split(",");
        List<String> stringList = new ArrayList<String>();
        for (String property : properties) {
            stringList.add(property);
        }

        goodsInformation.setGoodsTypeList(goodsTypeList);
        goodsInformation.setGoodsPropertyList(stringList);
        goodsInformation.setBillingPattern(goodsProperty.getBillingPattern());
        goodsInformation.setPriceType(goodsProperty.getPriceType());

        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        showVo.setResult(goodsInformation);
        return showVo;
    }

    /**
     * 创建商品价格
     *
     * @param goodsPriceList
     * @param showVo
     * @return
     */
    public ShowVo saveGoodsPrice(List<GoodsPrice> goodsPriceList, ShowVo showVo) {
        /**
         * 根据商品id查询此商品是否有价格数据存在,若没有则创建价格体系,
         * 若有数据存在,则此操作为修改价格,
         * 如果是修改价格,则应根据商品id先删除所有价格体系,再添加
         */
        GoodsPrice gp = new GoodsPrice();
        gp.setGoodsId(goodsPriceList.get(0).getGoodsId());
        List<GoodsPrice> gpl = goodsPriceMapper.queryGoodsPrice(gp);
        if (gpl.size() != 0) {
            //根据商品id先删除所有价格体系,再添加
            goodsPriceMapper.deleteGoodsPrice(goodsPriceList.get(0).getGoodsId());
            //添加
            showVo = insertGoodsPrice(goodsPriceList, showVo);
            return showVo;
        } else {
            //此商品没有价格体系，直接添加
            showVo = insertGoodsPrice(goodsPriceList, showVo);
            return showVo;
        }
    }

    /**
     * 将商品价格添加数据库
     *
     * @param goodsPriceList
     * @param showVo
     * @return
     */
    public ShowVo insertGoodsPrice(List<GoodsPrice> goodsPriceList, ShowVo showVo) {
        //根据商品id查询商品的计费模式 计费模式 0:按需;1:包年包月;2:按需和包年包月
        String goodsId = goodsPriceList.get(0).getGoodsId();
        GoodsProperty goodsProperty = goodsPropertyMapper.queryGoodsPropertyById(goodsId);
        for (GoodsPrice goodsPrice : goodsPriceList) {
            //根据计费模式判断价格是否为空
            showVo = judgeNull(goodsProperty, goodsPrice, showVo);
            if (showVo.getCode() != ReturnData.SUCCESS.getCode()) return showVo;

            goodsPrice.setId(UuidUtils.get32UUID());
            goodsPrice.setCreateTime(DateUtils.getnow());
            goodsPriceMapper.saveGoodsPrice(goodsPrice);
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 判断参数是否为空
     *
     * @param goodsProperty
     * @param goodsPrice
     * @param showVo
     * @return
     */
    public ShowVo judgeNull(GoodsProperty goodsProperty, GoodsPrice goodsPrice, ShowVo showVo) {
        if (goodsProperty.getBillingPattern().equals("0")) {
            if (StringUtils.isBlank(goodsPrice.getPriceNeed())) {
                showVo.setCode(ReturnData.GOODS_PRICE_NEED_NOT_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_PRICE_NEED_NOT_NULL.getMessage());
                return showVo;
            }
        } else if (goodsProperty.getBillingPattern().equals("1")) {
            if (StringUtils.isBlank(goodsPrice.getPriceMonth())) {
                showVo.setCode(ReturnData.GOODS_PRICE_MONTH_NOT_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_PRICE_MONTH_NOT_NULL.getMessage());
                return showVo;
            }
        } else {
            if (StringUtils.isBlank(goodsPrice.getPriceNeed()) || StringUtils.isBlank(goodsPrice.getPriceMonth())) {
                showVo.setCode(ReturnData.GOODS_PRICE_NEED_MONTH_NOT_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_PRICE_NEED_MONTH_NOT_NULL.getMessage());
                return showVo;
            }
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 删除商品
     *
     * @param ids
     * @param showVo
     * @return
     */
    public ShowVo deleteGoods(String[] ids, ShowVo showVo) {
        //如果商品未下架，不允许删除
        for (String id : ids) {
            //根据商品id查询商品 商品的状态 0:未发布;1:上架;2:下架;
            GoodsProperty goodsProperty = goodsPropertyMapper.queryGoodsPropertyById(id);
            if (goodsProperty.getStatus().equals("1")) {
                showVo.setCode(ReturnData.UP_GOODS_FORBID_DELETE.getCode());
                showVo.setMessage(ReturnData.UP_GOODS_FORBID_DELETE.getMessage());
                return showVo;
            }
            //删除商品之前先删除商品对应的价格
            goodsPriceMapper.deleteGoodsPrice(id);
            //再删除商品的类型
            goodsTypeMapper.deleteGoodsType(id);
            //删除商品id
            goodsPropertyMapper.deleteGoods(goodsProperty);
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 根据条件分页查询商品列表
     *
     * @param goodsProperty
     * @param page
     * @param rows
     * @param showVo
     * @return
     */
    public ShowVo queryGoodsByPage(GoodsProperty goodsProperty, Integer page, Integer rows, ShowVo showVo) {
        PageHelper.startPage(page, rows);
        List<GoodsProperty> goodsPropertyList = goodsPropertyMapper.queryGoodsProperty(goodsProperty);
        PageInfo<GoodsProperty> pageInfo = new PageInfo<GoodsProperty>(goodsPropertyList);
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        showVo.setResult(pageInfo);
        return showVo;
    }

    /**
     * 查看，查看某个商品的详情
     *
     * @param goodsProperty
     * @return
     */
    public ShowVo queryGoodsPropertyById(GoodsProperty goodsProperty, ShowVo showVo) {
        GoodsPriceVo goodsPriceVo = new GoodsPriceVo();
        //根据商品id查询此商品对象
        GoodsProperty gp = goodsPropertyMapper.queryGoodsPropertyById(goodsProperty.getId());
        //根据商品id查询此商品类型对象
        GoodsType gt = new GoodsType();
        gt.setGoodsId(goodsProperty.getId());
        List<GoodsType> goodsTypeList = goodsTypeMapper.queryGoodsType(gt);
        List<GoodsTypePriceVo> goodsTypePriceVoList = new ArrayList<GoodsTypePriceVo>();
        //通过商品类型id查询商品价格
        for (GoodsType goodsType : goodsTypeList) {
            GoodsPrice goodsPrice = new GoodsPrice();
            goodsPrice.setGoodsTypeId(goodsType.getId());
            List<GoodsPrice> goodsPriceList = goodsPriceMapper.queryGoodsPrice(goodsPrice);
            List<PropertyPriceVo> propertyPriceVoList = new ArrayList<PropertyPriceVo>();
            for (GoodsPrice price : goodsPriceList) {
                PropertyPriceVo propertyPriceVo = new PropertyPriceVo();
                BeanUtils.copyProperties(price, propertyPriceVo);
                propertyPriceVoList.add(propertyPriceVo);
            }
            GoodsTypePriceVo goodsTypePriceVo = new GoodsTypePriceVo();
            goodsTypePriceVo.setGoodsTypeId(goodsType.getId());
            goodsTypePriceVo.setGoodsTypeName(goodsType.getGoodsType());
            goodsTypePriceVo.setPropertyPriceVoList(propertyPriceVoList);

            goodsTypePriceVoList.add(goodsTypePriceVo);
        }

        BeanUtils.copyProperties(gp, goodsPriceVo);
        goodsPriceVo.setGoodsTypePriceVoList(goodsTypePriceVoList);

        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        showVo.setResult(goodsPriceVo);
        return showVo;
    }

    /**
     * 修改商品信息,商品价格除外
     *
     * @param goodsProperty
     * @return
     */
    public ShowVo updateGoodsProperty(GoodsProperty goodsProperty, ShowVo showVo) {
        String time = DateUtils.getnow();
        goodsProperty.setUpdateTime(time);
        Integer i = goodsPropertyMapper.updateGoodsProperty(goodsProperty);
        if (i != 1) {
            showVo.setCode(ReturnData.GOODS_UPDATE_FAIL.getCode());
            showVo.setMessage(ReturnData.GOODS_UPDATE_FAIL.getMessage());
            return showVo;
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

}
