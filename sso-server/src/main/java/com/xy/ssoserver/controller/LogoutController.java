package com.xy.ssoserver.controller;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {
    @GetMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) {
//        消除用户认证信息
        new SecurityContextLogoutHandler().logout(request, response, null);
//        重定向到登陆界面
        return "redirect:http://localhost:8080/server/login/";
    }
}
