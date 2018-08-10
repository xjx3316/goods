package com.example.utils;

/**
 * Created by xjx on 2018/8/3.
 */
public enum ReturnData {

    SUCCESS(200,"操作成功"),
    ERROR(500,"服务器异常"),
    REQUEST_PARAMETERS(400,"请求参数不能为空"),
    PAGE_ROWS_IS_NULL(1005,"分页条件不能为空"),

    //商品组(1000-1100)
    GOODS_GROUP_NAME_IS_NULL(1000,"商品组名字不能为空"),
    GOODS_GROUP_ID_IS_NULL(1001,"商品组ID不能为空"),
    GOODS_GROUP_SAVE_FAIL(1002,"商品组创建失败"),
    GOODS_GROUP_DELETE_FAIL(1003,"商品组删除失败"),
    GOODS_GROUP_UPDATE_FAIL(1004,"商品组修改失败"),
    GOODS_GROUP_HAVE_GOODS(1005,"此商品组有商品，不允许删除"),
    //商品(1100-1200)
    GOODS_SAVE_FAIL(1100,"商品添加失败"),
    GOODS_PROPERTY_SAVE_FAIL(1101,"商品属性添加失败"),
    GOODS_TYPE_SAVE_FAIL(1102,"商品类型添加失败"),
    GOODS_DELETE_FAIL(1103,"商品删除失败"),
    UP_GOODS_FORBID_DELETE(1104,"上架商品不允许删除"),
    GOODS_PRICE_NEED_NOT_NULL(1105,"按需价格不能为空"),
    GOODS_PRICE_MONTH_NOT_NULL(1106,"包年包月价格不能为空"),
    GOODS_PRICE_NEED_MONTH_NOT_NULL(1107,"按需和包年包月价格不能为空"),
    PROPERTY_PRICE_NOT_JSON(1108,"propertyPrice属性必须为JSON格式"),
    GOODS_UPDATE_FAIL(1109,"商品信息修改失败");

    private final Integer code;
    private final String message;

    ReturnData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
