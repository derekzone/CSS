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

    //TODO 加一条数据库唯一索引  按照目前的设计，同一个用户同一个商品，只能产生一条下单记录
    @RequestMapping("/buy")
    @ResponseBody
    public BaseResponse buy(@RequestBody List<OrderInfo> orderInfos,
                            HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null || user.getType() == 2) {
            return BaseResponse.fail();
        }
        boolean result = orderService.order(user.getId(), orderInfos.get(0).getId(), orderInfos.get(0).getNumber());
        if (result == true) {
            return BaseResponse.success();
        } else {
            return BaseResponse.fail();
        }
    }
}
