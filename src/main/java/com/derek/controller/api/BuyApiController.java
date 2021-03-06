package com.derek.controller.api;

import com.derek.annotation.Log;
import com.derek.exception.BaseException;
import com.derek.model.User;
import com.derek.model.request.OrderInfo;
import com.derek.model.response.BaseResponse;
import com.derek.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(BuyApiController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping("/buy")
    @ResponseBody
    @Log
    public BaseResponse buy(@RequestBody List<OrderInfo> orderInfos,
                            HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        logger.info("用户"+user.getUsername()+"购买"+orderInfos.toString());
        if (user == null || user.getType() == 2) {
            return BaseResponse.fail();
        }
        for (OrderInfo orderInfo :
                orderInfos) {
            boolean result = orderService.order(user.getId(), orderInfo.getId(), orderInfo.getNumber());
            if (!result) {
                throw new BaseException("下单错误!");
            }
        }
        return BaseResponse.success();
    }
}
