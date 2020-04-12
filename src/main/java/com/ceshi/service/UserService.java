package com.ceshi.service;

import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public interface UserService {

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    Boolean login(HttpServletResponse response,String userName, String password);
}
