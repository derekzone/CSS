//package com.derek.controller.api;
//
//import com.derek.model.response.BaseResponse;
//import com.derek.service.LoginLogoutService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
///**
// * @author Derek
// * @date 2018/3/21 19:06
// */
//
//@Controller
//@RequestMapping("/api")
//public class LoginLogoutController {
//
//    @Autowired
//    private LoginLogoutService loginLogoutService;
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public BaseResponse login(@RequestParam(value = "userName") String username,
//                              @RequestParam(value = "password") String password,
//                              HttpSession httpSession) {
//        boolean result = loginLogoutService.login(username, password, httpSession);
//        if (result == true) {
//            return BaseResponse.success();
//        } else {
//            return BaseResponse.fail();
//        }
//    }
//}
