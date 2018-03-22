package com.derek.service;

import java.util.HashSet;

/**
 * @author Derek
 * @date 2018/3/22 09:33
 */
public interface OrderService {
    public HashSet<Integer> getBuySet(int uid);
}
