package com.derek.controller;

import com.derek.model.Content;
import com.derek.model.Order;
import com.derek.model.User;
import com.derek.model.VO.ContentVO;
import com.derek.service.ContentService;
import com.derek.service.OrderService;
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
    @Autowired
    private OrderService orderService;

    @RequestMapping("/show")
    public String show(@RequestParam(value = "id", required = true) int id, HttpSession httpSession, ModelMap modelMap) {
        Content content = contentService.getById(id);
        modelMap.addAttribute("content", content);
        User user = (User) httpSession.getAttribute("user");
        if (user != null && content != null) {
            Order order = orderService.getByUidCid(user.getId(), content.getId());
            ContentVO contentVO = new ContentVO(content, order);
            modelMap.addAttribute("contentVO", contentVO);
            modelMap.addAttribute("user", user);
        }
        return "show";
    }
}
