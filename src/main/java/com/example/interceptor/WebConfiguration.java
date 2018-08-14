package com.example.interceptor;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xjx on 2018/7/19.
 */
//@Component
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    private static final Logger LOG = Logger.getLogger(WebConfiguration.class);

    /**
     * 拦截器加载的时间点在springcontext之前，所以在拦截器中注入自然为null，
     * 根据解决方法在配置拦截器链的类中先注入这个拦截器，同时这个类上需要@Configuration注解
     * @return
     */
    @Bean
    public LoginHandleIntercept localeInterceptor() {
        return new LoginHandleIntercept();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOG.info("WebConfiguration执行了");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        InterceptorRegistration ir = registry.addInterceptor(localeInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/");
        //ir.excludePathPatterns("/goods/queryGoodsByPage");
        super.addInterceptors(registry);
    }
}
