package com.derek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/21 18:59
 */
@Controller
public class LoginLogoutController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap modelMap, HttpSession httpSession) {
        modelMap.remove("user");
        httpSession.removeAttribute("user");
        return "login";
    }
}
