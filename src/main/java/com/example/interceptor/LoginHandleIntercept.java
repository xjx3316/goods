package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xjx on 2018/7/19.
 */
public class LoginHandleIntercept implements HandlerInterceptor {

    private static final Logger LOG = Logger.getLogger(WebConfiguration.class);

    public LoginHandleIntercept() {}

    @Value("${CMS.USER_URL}")
    private String cms_user_url;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        LOG.info("preHandle执行了");
        String userId = request.getParameter("exportUserId");
        LOG.info("goods项目拦截器中获取到的userId为:" + userId);
        if (StringUtils.isBlank(userId)) {
            response.getWriter().write("307");
            return false;
        }
        //根据userId查询user对象
        Map map = new HashMap<>();
        map.put("userId", userId);
        LOG.info("调用cms路径为: " + cms_user_url);
        String s = HttpUtils.doGet(cms_user_url, map);
        JSONObject jsonObject = JSONObject.parseObject(s);
        if (jsonObject == null) {
            LOG.info("调用cms项目查询用户对象返回空");
            response.getWriter().write("307");
            return false;
        }
        //获取User对象
        JSONObject jo = jsonObject.getJSONObject("object");
        LOG.info("调用cms项目查询用户对象,jo: " + jo);
        if (jo == null) {
            LOG.info("调用cms项目查询用户对象,User为空");
            response.getWriter().write("307");
            return false;
        }
        request.getSession().setAttribute("user", jo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
