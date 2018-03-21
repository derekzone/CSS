package com.derek.service;

import javax.servlet.http.HttpSession;

/**
 * @author Derek
 * @date 2018/3/21 20:42
 */
public interface LoginLogoutService {
    public boolean login(String username, String md5Password, HttpSession httpSession);
}
