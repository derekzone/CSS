package com.derek.service.impl;

import com.derek.model.User;
import com.derek.model.mapper.UserMapper;
import com.derek.service.LoginLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/21 20:43
 */
@Service
public class LoginLogoutServiceImpl implements LoginLogoutService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username, String md5Password, HttpSession httpSession) {
        User user = userMapper.verifyUser(username, md5Password);
        if (user != null) {
            httpSession.setAttribute("user", user);
            return true;
        } else {
            httpSession.removeAttribute("user");
            return false;
        }
    }
}
