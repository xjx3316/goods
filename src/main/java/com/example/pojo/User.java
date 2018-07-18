package com.example.pojo;

import java.io.Serializable;

/**
 * Created by xjx on 2018/7/18.
 */
public class User implements Serializable{

    private String id;
    private String userName;
    private int age;
    private String sex;//male/female

    public User() {
    }

    public User(String id, String userName, int age, String sex) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
