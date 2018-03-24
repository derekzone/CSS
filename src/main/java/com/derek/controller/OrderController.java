package com.derek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/24 20:02
 */
@Controller
public class OrderController {

    @RequestMapping("/settleAccount")
    public String settleAccount(HttpSession httpSession, ModelMap modelMap) {
        return "settleAccount";
    }
}
