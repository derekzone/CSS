package com.derek.controller;

import com.derek.model.Content;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/24 11:47
 */
@Controller
public class ShowController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/show")
    public String show(@RequestParam(value = "id", required = true) int id, HttpSession httpSession, ModelMap modelMap) {
        Content content = contentService.getById(id);
        modelMap.addAttribute("content", content);
        return "show";
    }
}
