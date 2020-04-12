package com.ceshi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfigurer implements WebMvcConfigurer  {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**","/resources/**")
                .addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("========== 进入自定义拦截器 ==========");
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/user/loading","/login.ftl","/error.ftl")
                .excludePathPatterns("/assets/login/assets/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/error")
        ;
    }

}