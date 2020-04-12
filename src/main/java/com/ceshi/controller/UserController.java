package com.ceshi.controller;

import com.ceshi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 加载登录界面
     *
     * @return
     */
    @GetMapping("/loading")
    public String loading() {
        return "module/views/login";
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public BaseResult login(HttpServletResponse response,String userName, String password) {
        Boolean status = userService.login(response,userName, password);
        if (status) {return BaseResult.Success();} else {return BaseResult.Error("登录失败，请重新登录！");}
    }


}
