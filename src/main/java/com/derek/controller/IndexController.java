package com.derek.controller;

import com.derek.model.Content;
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
import java.util.HashSet;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:32
 */
@Controller
public class IndexController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String index(ModelMap modelMap, HttpSession httpSession, @RequestParam(value = "type", required = false) Integer type) {
        List<Content> contentList = contentService.getAll();
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            modelMap.addAttribute("contentList", contentList);
        } else {
            HashSet<Integer> buySet = orderService.getBuySet(user.getId());
            List<ContentVO> contentVOS = contentService.getAllVO(buySet);
            modelMap.addAttribute("contentVOList", contentVOS);
        }
        return "index";
    }
}
