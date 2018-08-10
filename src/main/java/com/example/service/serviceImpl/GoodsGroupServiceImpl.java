package com.example.service.serviceImpl;

import com.example.mapper.GoodsGroupMapper;
import com.example.mapper.GoodsPropertyMapper;
import com.example.pojo.GoodsGroup;
import com.example.pojo.GoodsProperty;
import com.example.service.GoodsGroupService;
import com.example.utils.DateUtils;
import com.example.utils.ReturnData;
import com.example.utils.ShowVo;
import com.example.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xjx on 2018/8/3.
 */
@Service
public class GoodsGroupServiceImpl implements GoodsGroupService {

    private static final Logger LOG = Logger.getLogger(GoodsGroupServiceImpl.class);
    @Autowired
    private GoodsGroupMapper goodsGroupMapper;
    @Autowired
    private GoodsPropertyMapper goodsPropertyMapper;

    /**
     * 添加商品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    public ShowVo saveGoodsGroup(GoodsGroup goodsGroup, ShowVo showVo) {
        String id = UuidUtils.get32UUID();
        String time = DateUtils.getnow();
        goodsGroup.setId(id);
        goodsGroup.setCreateTime(time);
        Integer i = goodsGroupMapper.saveGoodsGroup(goodsGroup);
        if (i != 1) {
            showVo.setCode(ReturnData.GOODS_GROUP_SAVE_FAIL.getCode());
            showVo.setMessage(ReturnData.GOODS_GROUP_SAVE_FAIL.getMessage());
            return showVo;
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 删除商品组
     *
     * @param goodsGroupIds
     * @param showVo
     * @return
     */
    public ShowVo deleteGoodsGroup(String[] goodsGroupIds, ShowVo showVo) {
        for (String goodsGroupId : goodsGroupIds) {
            //如果此商品组下有商品，不允许删除商品组
            GoodsProperty goodsProperty = new GoodsProperty();
            goodsProperty.setGoodsGroupId(goodsGroupId);
            List<GoodsProperty> goodsPropertyList = goodsPropertyMapper.queryGoodsProperty(goodsProperty);
            if (goodsPropertyList.size() != 0) {
                showVo.setCode(ReturnData.GOODS_GROUP_HAVE_GOODS.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_HAVE_GOODS.getMessage());
                return showVo;
            }
            GoodsGroup goodsGroup = new GoodsGroup();
            goodsGroup.setId(goodsGroupId);
            goodsGroupMapper.deleteGoodsGroup(goodsGroup);
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 修改商品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    public ShowVo updateGoodsGroup(GoodsGroup goodsGroup, ShowVo showVo) {
        String time = DateUtils.getnow();
        goodsGroup.setUpdateTime(time);
        Integer i = goodsGroupMapper.updateGoodsGroup(goodsGroup);
        if (i != 1) {
            showVo.setCode(ReturnData.GOODS_GROUP_UPDATE_FAIL.getCode());
            showVo.setMessage(ReturnData.GOODS_GROUP_UPDATE_FAIL.getMessage());
            return showVo;
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 查询产品组
     * page=0&&rows=0不分页，否则分页
     *
     * @param page
     * @param rows
     * @param showVo
     * @return
     */
    public ShowVo queryGoodsGroupByPage(Integer page, Integer rows, GoodsGroup goodsGroup, ShowVo showVo) {
        if (page == 0 && rows == 0) {
            //不分页
            List<GoodsGroup> list = goodsGroupMapper.queryGoodsGroup(goodsGroup);
            showVo.setResult(list);
        } else {
            //分页
            PageHelper.startPage(page, rows);
            List<GoodsGroup> list = goodsGroupMapper.queryGoodsGroup(goodsGroup);
            PageInfo<GoodsGroup> pageInfo = new PageInfo<GoodsGroup>(list);
            showVo.setResult(pageInfo);
        }
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        return showVo;
    }

    /**
     * 根据id查询产品组
     *
     * @param goodsGroup
     * @param showVo
     * @return
     */
    public ShowVo queryGoodsGroupById(GoodsGroup goodsGroup, ShowVo showVo) {
        GoodsGroup g = goodsGroupMapper.queryGoodsGroupById(goodsGroup);
        showVo.setCode(ReturnData.SUCCESS.getCode());
        showVo.setMessage(ReturnData.SUCCESS.getMessage());
        showVo.setResult(g);
        return showVo;
    }

    public static void main(String[] args) {
        String s = "2-8";
        String[] split = s.split("-");
        for (String s1 : split) {
            LOG.info(s1.length());
            LOG.info(s1);
        }
    }
}
