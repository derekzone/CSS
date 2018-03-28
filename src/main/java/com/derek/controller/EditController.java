package com.derek.controller;

import com.derek.model.Content;
import com.derek.model.User;
import com.derek.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @author Derek
 * @date 2018/3/25 11:09
 */
@Controller
public class EditController {
    private final static Logger logger = LoggerFactory.getLogger(EditController.class);
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
        logger.info("用户:"+user.getUsername()+"编辑商品");
        modelMap.addAttribute("content", content);
        return "edit";
    }

    @RequestMapping("/editSubmit")
    public String editSubmit(@RequestParam("id") Integer id,
                             @RequestParam("title") String title,
                             @RequestParam("summary") String summary,
                             @RequestParam("image") String image,
                             @RequestParam("detail") String detail,
                             @RequestParam("price") BigDecimal price,
                             ModelMap modelMap,HttpSession httpSession) throws Exception {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "login";
        }
        if (user.getType() == 1) {
            httpSession.removeAttribute("user");
            return "login";
        }
        Content content = new Content();
        content.setId(id);
        content.setTitle(title);
        content.setSummary(summary);
        content.setImage(image);
        content.setDetail(detail);
        content.setPrice(price);
        boolean result = contentService.update(content);
        if (result == false) {
            throw new Exception("编辑失败！");
        }
        modelMap.addAttribute("id", id);
        return "editSubmit";
    }
}
