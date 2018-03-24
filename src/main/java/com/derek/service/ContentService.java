package com.derek.service;

import com.derek.model.Content;
import com.derek.model.VO.ContentVO;

import java.util.HashSet;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:45
 */
public interface ContentService {
    /**
     * 获取所有Content
     *
     * @return
     */
    public List<Content> getAll();

    /**
     * 获取contentVO
     *
     * @param buySet
     * @return
     */
    public List<ContentVO> getAllVO(HashSet<Integer> buySet);

    /**
     * 只返回已购买或未购买的VO
     *
     * @param buySet
     * @param isBuy
     * @return
     */
    public List<ContentVO> filterVO(HashSet<Integer> buySet, boolean isBuy);

    /**
     * 根据id查找商品详情
     *
     * @param id
     * @return
     */
    public Content getById(int id);

    /**
     * 根据用户id查找所有购买商品
     * @param uid 用户id
     * @return
     */
    public List<ContentVO> queryVOByUid(int uid);
}
