package com.derek.service.impl;

import com.derek.model.mapper.OrderMapper;
import com.derek.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/22 09:34
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public HashSet<Integer> getBuySet(int uid) {
        List<Integer> buyList = orderMapper.getBuySet(uid);
        return new HashSet<Integer>(buyList);
    }
}
