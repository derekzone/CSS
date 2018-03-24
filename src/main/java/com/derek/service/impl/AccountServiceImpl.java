package com.derek.service.impl;

import com.derek.model.mapper.OrderMapper;
import com.derek.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Derek
 * @date 2018/3/24 22:59
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public BigDecimal totalCost(int uid) {
        return orderMapper.computeTotalCost(uid);
    }
}
