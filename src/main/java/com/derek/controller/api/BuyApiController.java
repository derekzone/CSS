package com.derek.controller.api;

import com.derek.model.User;
import com.derek.model.request.OrderInfo;
import com.derek.model.response.BaseResponse;
import com.derek.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/24 20:20
 */
@Controller
@RequestMapping("/api")
public class BuyApiController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/buy")
    @ResponseBody

    //TODO 统一做异常抛出  切面处理抛出异常
    public BaseResponse buy(@RequestBody List<OrderInfo> orderInfos,
                            HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getType() == 2) {
            return BaseResponse.fail();
        }
        for (OrderInfo orderInfo :
                orderInfos) {
            orderService.order(user.getId(), orderInfo.getId(), orderInfo.getNumber());
        }
        //TODO 异常处理
        boolean result = true;
        if (result == true) {
            return BaseResponse.success();
        } else {
            return BaseResponse.fail();
        }
    }
}
