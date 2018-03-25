package com.derek.controller;

import com.derek.model.Content;
import com.derek.model.User;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/25 11:09
 */
@Controller
public class EditController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/edit")
    public String edit(@RequestParam(value = "id", required = true) int id, HttpSession httpSession, ModelMap modelMap) {
        Content content = contentService.getById(id);
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "login";
        }
        if (user.getType() == 1) {
            httpSession.removeAttribute("user");
            return "login";
        }
        modelMap.addAttribute("content", content);
        return "edit";
    }
}
