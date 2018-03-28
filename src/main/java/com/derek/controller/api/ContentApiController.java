package com.derek.controller.api;

import com.derek.model.Content;
import com.derek.model.User;
import com.derek.model.response.BaseResponse;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/28 08:06
 */
@Controller
@RequestMapping("/api")
public class ContentApiController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/delete")
    @ResponseBody
    public BaseResponse deleteContent(HttpSession httpSession, @RequestParam(value = "id") int id) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getType() != 2) {
            return BaseResponse.fail("请登录后操作");
        }
        Content content = contentService.getById(id);
        if (content == null) {
            return BaseResponse.fail("商品已删除！");
        }
        if (content.getSid() != user.getId()) {
            return BaseResponse.fail("没有操作权限！");
        }
        boolean result = contentService.delete(id);
        if (result) {
            return BaseResponse.success("删除成功！");
        } else {
            return BaseResponse.fail("删除错误！");
        }
    }
}
