package com.derek.service;

import com.derek.model.Order;

import java.util.HashSet;

/**
 * @author Derek
 * @date 2018/3/22 09:33
 */
public interface OrderService {

    /**
     * 获取该用户已购买的商品集合
     *
     * @param uid 用户id
     * @return
     */
    public HashSet<Integer> getBuySet(int uid);

    /**
     * 返回用户是否已购买某商品
     *
     * @param uid 用户id
     * @param cid 商品id
     * @return
     */
    public boolean checkBuy(int uid, int cid);


    /**
     * 根据用户id和商品id查询订单
     *
     * @param uid
     * @param cid
     * @return
     */
    public Order getByUidCid(int uid, int cid);

    /**
     * 下单
     *
     * @param uid    用户id
     * @param cid    商品id
     * @param number 购买数量
     * @return
     */
    public boolean order(int uid, int cid, int number);

    /**
     * 查询商家售出商品id集合
     *
     * @param uid
     * @return
     */
    public HashSet<Integer> getSoldSet(int uid);

}
