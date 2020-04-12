package com.ceshi.serviceImpl;

import com.ceshi.Application;
import com.ceshi.dao.UserDao;
import com.ceshi.entity.User;
import com.ceshi.service.UserService;
import com.ceshi.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Service("UserService")
class UserServiceImpl implements UserService {
    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    UserDao userDao;


    @Override
    public Boolean login(HttpServletResponse response, String userName, String password) {
        User user = userDao.queryUsers(userName);
        if (user.getPassword().equals(password)){
            Cookie cookie = new Cookie("code", Base64.getBase64(user.getUserName()));
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }
}
