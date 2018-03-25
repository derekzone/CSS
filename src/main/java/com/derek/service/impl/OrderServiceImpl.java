package com.derek.service.impl;

import com.derek.model.Content;
import com.derek.model.Order;
import com.derek.model.mapper.ContentMapper;
import com.derek.model.mapper.OrderMapper;
import com.derek.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public HashSet<Integer> getBuySet(int uid) {
        List<Integer> buyList = orderMapper.getBuySet(uid);
        return new HashSet<Integer>(buyList);
    }

    @Override
    public boolean checkBuy(int uid, int cid) {
        Order order = orderMapper.getByUserContent(uid, cid);
        return order != null;
    }

    @Override
    public Order getByUidCid(int uid, int cid) {
        return orderMapper.getByUserContent(uid, cid);
    }

    @Override
    public boolean order(int uid, int cid, int number) {
        Content content = contentMapper.selectByPrimaryKey(cid);
        Order order = new Order();
        order.setCid(cid);
        order.setNum(number);
        order.setPrice(content.getPrice());
        order.setUid(uid);
        order.setGmtCreate(new Date());
        return orderMapper.order(order);
    }

    @Override
    public HashSet<Integer> getSoldSet(int uid) {
        List<Integer> soldList = orderMapper.getSoldSet(uid);
        return new HashSet<Integer>(soldList);
    }

}
