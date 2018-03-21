package com.derek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Derek
 * @date 2018/3/21 18:59
 */
@Controller
public class LoginLogoutController {

    @RequestMapping("/login")
    public String index() {
        return "login";
    }
}
