package com.example.utils;

/**
 * Created by xjx on 2018/8/3.
 */
public enum ReturnData {

    SUCCESS(200,"操作成功"),
    ERROR(500,"服务器异常"),

    //商品组(1000-1100)
    GOODS_GROUP_NAME_IS_NULL(1000,"商品组名字不能为空"),
    GOODS_GROUP_ID_IS_NULL(1001,"商品组ID不能为空"),
    GOODS_GROUP_SAVE_FAIL(1002,"商品组创建失败"),
    GOODS_GROUP_DELETE_FAIL(1003,"商品组删除失败"),
    GOODS_GROUP_UPDATE_FAIL(1004,"商品组修改失败"),
    PAGE_ROWS_IS_NULL(1005,"分页条件不能为空");

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
