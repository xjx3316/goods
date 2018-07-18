package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xjx on 2018/7/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/saveUser")
    public Object saveUser(User user){
        try {
            userService.saveUser(user);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "添加用户发生异常";
        }
    }
}
