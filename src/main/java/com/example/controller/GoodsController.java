package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.ExportInformation;
import com.example.pojo.GoodsPrice;
import com.example.pojo.GoodsProperty;
import com.example.service.GoodsService;
import com.example.utils.JsonUtils;
import com.example.utils.ReturnData;
import com.example.utils.ShowVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xjx on 2018/8/6.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final Logger LOG = Logger.getLogger(GoodsController.class);
    @Autowired
    private GoodsService goodsService;

    /**
     * 添加商品
     *
     * @param goodsProperty
     * @return
     */
    @PostMapping("/saveGoods")
    public Object saveGoods(@RequestBody GoodsProperty goodsProperty) {
        ShowVo showVo = new ShowVo();
        LOG.info("添加商品,传参goodsProperty: " + goodsProperty);
        try {
            //判断空参
            if (StringUtils.isBlank(goodsProperty.getGoodsGroupId()) || StringUtils.isBlank(goodsProperty.getGoodsGroupName()) ||
                    StringUtils.isBlank(goodsProperty.getGoodsName()) || StringUtils.isBlank(goodsProperty.getBillingPattern()) ||
                    StringUtils.isBlank(goodsProperty.getRegionId()) || StringUtils.isBlank(goodsProperty.getRegionName()) ||
                    StringUtils.isBlank(goodsProperty.getPriceType()) || StringUtils.isBlank(goodsProperty.getGoodsProperty()) ||
                    StringUtils.isBlank(goodsProperty.getGoodsType())) {
                showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                return showVo;
            }
            showVo = goodsService.saveGoods(goodsProperty, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 根据商品id查询商品类型,商品的属性,商品的计费模式和计价方式
     *
     * @param goodsId
     * @return
     */
    @GetMapping("/queryGoodsInformation")
    public Object queryGoodsInformation(String goodsId) {
        ShowVo showVo = new ShowVo();
        LOG.info("查询商品类型,传参goodsId: " + goodsId);
        try {
            if (StringUtils.isBlank(goodsId)) {
                showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                return showVo;
            }
            showVo = goodsService.queryGoodsInformation(goodsId, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 创建商品价格/修改商品价格
     *
     * @param goodsPriceList
     * @return
     */
    @PostMapping("/saveGoodsPrice")
    public Object saveGoodsPrice(@RequestBody List<GoodsPrice> goodsPriceList) {
        ShowVo showVo = new ShowVo();
        LOG.info("创建商品价格,传参为goodsPrice: " + goodsPriceList);
        try {
            //判断空参
            for (GoodsPrice goodsPrice : goodsPriceList) {
                if (StringUtils.isBlank(goodsPrice.getGoodsId()) || StringUtils.isBlank(goodsPrice.getGoodsTypeId()) ||
                        StringUtils.isBlank(goodsPrice.getGoodsTypeName()) || StringUtils.isBlank(goodsPrice.getPropertyPrice())) {
                    showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                    showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                    return showVo;
                }
                //判断propertyPrice属性是否为json格式的String
                boolean json = JsonUtils.isJson(goodsPrice.getPropertyPrice());
                if (json == false) {
                    showVo.setCode(ReturnData.PROPERTY_PRICE_NOT_JSON.getCode());
                    showVo.setMessage(ReturnData.PROPERTY_PRICE_NOT_JSON.getMessage());
                    return showVo;
                }
            }
            showVo = goodsService.saveGoodsPrice(goodsPriceList, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 删除商品
     *
     * @param ids
     * @return
     */
    @GetMapping("/deleteGoods")
    public Object deleteGoods(String[] ids) {
        ShowVo showVo = new ShowVo();
        LOG.info("删除商品,ids: " + ids);
        try {
            //判断空参
            if (ids == null || ids.length == 0) {
                showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                return showVo;
            }
            showVo = goodsService.deleteGoods(ids, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 修改商品信息,商品价格除外
     * (修改内容包括发布,下架,商品名称,计费模式，区域)
     *
     * @param goodsProperty
     * @return
     */
    @PostMapping("/updateGoodsProperty")
    public Object updateGoodsProperty(@RequestBody GoodsProperty goodsProperty) {
        ShowVo showVo = new ShowVo();
        try {
            //判断空参
            if (StringUtils.isBlank(goodsProperty.getId())) {
                showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                return showVo;
            }
            showVo = goodsService.updateGoodsProperty(goodsProperty, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }


    /**
     * 根据条件分页查询商品列表
     *
     * @param goodsProperty
     * @return
     */
    @GetMapping("/queryGoodsByPage")
    public Object queryGoodsByPage(GoodsProperty goodsProperty, Integer page, Integer rows) {
        ShowVo showVo = new ShowVo();
        LOG.info("根据条件分页查询商品列表,传参为goodsProperty: " + goodsProperty);
        try {
            //判断空参
            if (page == null || rows == null) {
                showVo.setCode(ReturnData.PAGE_ROWS_IS_NULL.getCode());
                showVo.setMessage(ReturnData.PAGE_ROWS_IS_NULL.getMessage());
                return showVo;
            }
            showVo = goodsService.queryGoodsByPage(goodsProperty, page, rows, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    /**
     * 查看，查看某个商品的详情
     *
     * @param goodsProperty
     * @return
     */
    @GetMapping("/queryGoodsPropertyById")
    public Object queryGoodsPropertyById(GoodsProperty goodsProperty) {
        ShowVo showVo = new ShowVo();
        LOG.info("查看某个商品的详情,传参为goodsProperty: " + goodsProperty);
        try {
            //判断空参
            if (StringUtils.isBlank(goodsProperty.getId())) {
                showVo.setCode(ReturnData.REQUEST_PARAMETERS.getCode());
                showVo.setMessage(ReturnData.REQUEST_PARAMETERS.getMessage());
                return showVo;
            }
            showVo = goodsService.queryGoodsPropertyById(goodsProperty, showVo);
        } catch (Exception e) {
            e.printStackTrace();
            showVo.setCode(ReturnData.ERROR.getCode());
            showVo.setMessage(ReturnData.ERROR.getMessage());
            return showVo;
        }
        return showVo;
    }

    //导出
    @PostMapping("/exportGoodsPrice")
    public void exportGoodsPrice(HttpServletResponse response, @RequestBody List<ExportInformation> exportInformationList) {
        try {
            String fileName = new Date().getTime() + ".xls";
            fileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
            response.setContentType("applicationnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("商品价格");
            sheet.setDefaultColumnWidth(15);
            HSSFCellStyle style = wb.createCellStyle();
            HSSFRow row = sheet.createRow(0);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            HSSFCell cell = row.createCell(0);

            for (int i = 0; i < exportInformationList.size(); i++) {
                String goodsType = exportInformationList.get(i).getGoodsType();//获取商品类型
                String[] property = exportInformationList.get(i).getProperty().split(",");//获取商品需要展示的列属性
                String string = exportInformationList.get(i).getPropertyPrice();//获取价格数据
                JSONArray jsonArray = (JSONArray) JSONArray.parse(string);
                for (int j = 0; j < property.length; j++) {//遍历四个属性 cpu,ram,按需,包年包月
                    if (j == 0) {
                        cell.setCellValue(goodsType);
                        cell.setCellStyle(style);
                        cell = row.createCell(j);
                    } else {
                        cell.setCellValue(property[j-1]);
                        cell.setCellStyle(style);
                        cell = row.createCell(i);
                    }
                }
                //遍历价格数据[{cpu:1,ram:1,按需:0.1,包年包月:1},{cpu:1,ram:2,按需:0.2,包年包月:2},{cpu:2,ram:2,按需:0.3,包年包月:3}]
                for (int k = 0; k < jsonArray.size(); k++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(k);
                    row = sheet.createRow(k + 1);
                    row.createCell(k).setCellValue(jsonObject.getString(property[k]));
                }
            }

            OutputStream ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String s = "[{cpu:1,ram:1,按需:0.1,包年包月:1},{cpu:1,ram:2,按需:0.2,包年包月:2},{cpu:2,ram:2,按需:0.3,包年包月:3}]";
        JSONArray jsonArray = (JSONArray) JSONArray.parse(s);
        LOG.info(jsonArray);
    }

}
