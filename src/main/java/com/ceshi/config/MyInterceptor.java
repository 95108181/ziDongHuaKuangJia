package com.ceshi.config;

import com.ceshi.util.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class MyInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        System.out.println("======== 拦截器拦截 ========");
        if (StringUtils.isBlank(CookieUtils.getCookie(request, "code"))) {
            response.sendRedirect("/user/loading");
            return false;
        }
        return true;
    }


}
