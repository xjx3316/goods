package com.example.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xjx on 2018/8/9.
 */
public class JsonUtils {
    /**
     * 判断数据是否为json格式的字符串
     * @param str
     * @return
     */
    public static boolean isJson(String str) {
        try {
            JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
