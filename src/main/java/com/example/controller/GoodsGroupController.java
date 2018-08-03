package com.example.controller;

import com.example.pojo.GoodsGroup;
import com.example.service.GoodsGroupService;
import com.example.utils.ReturnData;
import com.example.utils.ShowVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xjx on 2018/8/3.
 */
@RestController
@RequestMapping("/goodsGroup")
public class GoodsGroupController {

    private static final Logger LOG = Logger.getLogger(GoodsGroupController.class);
    @Autowired
    private GoodsGroupService goodsGroupService;

    /**
     * 添加商品组
     *
     * @param goodsGroup
     * @return
     */
    @PostMapping("/saveGoodsGroup")
    public Object saveGoodsGroup(@RequestBody GoodsGroup goodsGroup) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (StringUtils.isBlank(goodsGroup.getGoodsGroupName())) {
                showVo.setCode(ReturnData.GOODS_GROUP_NAME_IS_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_NAME_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsGroupService.saveGoodsGroup(goodsGroup, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 删除商品组
     *
     * @param goodsGroup
     * @return
     */
    @GetMapping("/deleteGoodsGroup")
    public Object deleteGoodsGroup(GoodsGroup goodsGroup) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (StringUtils.isBlank(goodsGroup.getId())) {
                showVo.setCode(ReturnData.GOODS_GROUP_ID_IS_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_ID_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsGroupService.deleteGoodsGroup(goodsGroup, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 修改商品组
     *
     * @param goodsGroup
     * @return
     */
    @PostMapping("/updateGoodsGroup")
    public Object updateGoodsGroup(@RequestBody GoodsGroup goodsGroup) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (StringUtils.isBlank(goodsGroup.getId())) {
                showVo.setCode(ReturnData.GOODS_GROUP_ID_IS_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_ID_IS_NULL.getMessage());
                return showVo;
            }
            if (StringUtils.isBlank(goodsGroup.getGoodsGroupName())) {
                showVo.setCode(ReturnData.GOODS_GROUP_NAME_IS_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_NAME_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsGroupService.updateGoodsGroup(goodsGroup, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 查询产品组
     * page=0&&rows=0不分页，否则分页
     *
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/queryGoodsGroupByPage")
    public Object queryGoodsGroupByPage(Integer page, Integer rows, GoodsGroup goodsGroup) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (page == null || rows == null) {
                showVo.setCode(ReturnData.PAGE_ROWS_IS_NULL.getCode());
                showVo.setMessage(ReturnData.PAGE_ROWS_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsGroupService.queryGoodsGroupByPage(page, rows, goodsGroup, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 根据id查询产品组
     *
     * @param goodsGroup
     * @return
     */
    @GetMapping("/queryGoodsGroupById")
    public Object queryGoodsGroupById(GoodsGroup goodsGroup) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (StringUtils.isBlank(goodsGroup.getId())) {
                showVo.setCode(ReturnData.GOODS_GROUP_ID_IS_NULL.getCode());
                showVo.setMessage(ReturnData.GOODS_GROUP_ID_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsGroupService.queryGoodsGroupById(goodsGroup, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

}
