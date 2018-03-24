package com.derek.controller;

import com.derek.model.User;
import com.derek.model.VO.ContentVO;
import com.derek.service.AccountService;
import com.derek.service.ContentService;
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

    //TODO 重构优化  各个Service的分工
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
        List<ContentVO> contentVOS = contentService.queryVOByUid(user.getId());
        modelMap.addAttribute("contentVOS", contentVOS);
        BigDecimal totalPrice = accountService.totalCost(user.getId());
        modelMap.addAttribute("total", totalPrice);
        return "account";
    }
}
