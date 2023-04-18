package com.xy.ssoclient1.controller;

import com.xy.ssoclient1.Utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", SessionUtil.getCurrentUserName());
        model.addAttribute("roles", SessionUtil.getAuthorities());
        return "index";
    }
}
