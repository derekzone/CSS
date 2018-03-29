package com.derek.controller;

import com.derek.model.User;
import com.derek.model.VO.ContentVO;
import com.derek.service.AccountService;
import com.derek.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/24 22:27
 */
@Controller
public class AccountController {

    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private ContentService contentService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/account")
    public String account(HttpSession httpSession, ModelMap modelMap) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "login";
        }
        logger.info("用户:" + user.getUsername() + "查看账务");
        List<ContentVO> contentVOS = contentService.queryVOByUid(user.getId());
        modelMap.addAttribute("contentVOS", contentVOS);
        BigDecimal totalPrice = accountService.totalCost(user.getId());
        modelMap.addAttribute("total", totalPrice);
        return "account";
    }
}
