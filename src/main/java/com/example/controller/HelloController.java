package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by xjx on 2018/7/19.
 */
@RestController
public class HelloController {

    private static final Logger LOG = Logger.getLogger(HelloController.class);

    public static void main(String[] args) {
        System.out.println("hello");
    }

    @GetMapping("/sayHello")
    public String sayHello(HttpServletRequest request) {
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        LOG.info("locale:" + locale);
        LOG.info("language:" + language);
        LOG.info("country:" + country);
        return "hello";
    }
}
