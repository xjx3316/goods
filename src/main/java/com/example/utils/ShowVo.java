package com.example.utils;

import java.io.Serializable;

/**
 * Created by xjx on 2018/8/3.
 */
public class ShowVo implements Serializable{

    private Integer code;
    private String message;
    private Object result;

    public ShowVo() {
    }

    public ShowVo(Integer code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ShowVo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
