package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by czz on 2017/7/25.
 */
public class DateUtils {

    /**
     * 获取当前时间
     */
    public static String getnow() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
