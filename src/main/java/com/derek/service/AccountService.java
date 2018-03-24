package com.derek.service;

import java.math.BigDecimal;

/**
 * @author Derek
 * @date 2018/3/24 22:57
 */
public interface AccountService {
    /**
     * 查找该用户总花销
     * @param uid
     * @return
     */
    public BigDecimal totalCost(int uid);
}
