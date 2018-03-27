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
import java.math.BigDecimal;

/**
 * @author Derek
 * @date 2018/3/27 22:14
 */
@Controller
public class PublicController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/public")
    public String pubContent(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "login";
        }
        if (user.getType() == 1) {
            httpSession.removeAttribute("user");
            return "login";
        }
        return "public";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(HttpSession httpSession,
                               @RequestParam("price") BigDecimal price, @RequestParam("title") String title,
                               @RequestParam("image") String image, @RequestParam("summary") String summary,
                               @RequestParam("detail") String detail,
                               ModelMap modelMap) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getType() != 2) {
            return "login";
        }
        Content content = new Content();
        content.setSid(user.getId());
        content.setPrice(price);
        content.setSummary(summary);
        content.setDetail(detail);
        content.setImage(image);
        content.setTitle(title);
        contentService.addContent(content);
        modelMap.addAttribute("id", content.getId());
        return "publicSubmit";
    }
}
