package com.example.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xjx on 2018/8/10.
 */
public class ExportInformation implements Serializable {
    private String rows;//列的属性名
    private List<String> stringList;//价格信息

    public ExportInformation() {
    }

    public ExportInformation(String rows, List<String> stringList) {
        this.rows = rows;
        this.stringList = stringList;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public String toString() {
        return "ExportInformation{" +
                "rows='" + rows + '\'' +
                ", stringList=" + stringList +
                '}';
    }
}
