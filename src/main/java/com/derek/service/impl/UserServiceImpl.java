package com.derek.service.impl;

import com.derek.model.User;
import com.derek.model.mapper.UserMapper;
import com.derek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Derek
 * @date 2018/3/21 09:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
