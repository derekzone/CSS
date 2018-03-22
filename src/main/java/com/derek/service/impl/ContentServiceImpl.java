package com.derek.service.impl;

import com.derek.model.Content;
import com.derek.model.VO.ContentVO;
import com.derek.model.mapper.ContentMapper;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:46
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    /**
     * 获取所有商品
     *
     * @return 商品list
     */
    @Override
    public List<Content> getAll() {
        return contentMapper.selectAll();
    }

    /**
     * 获取商品VO对象
     *
     * @param buySet 已购买商品id的set集合
     * @return 商品VO list
     */
    @Override
    public List<ContentVO> getAllVO(HashSet<Integer> buySet) {
        List<Content> contents = getAll();
        List<ContentVO> contentVOS = ContentVO.buildFromList(contents, buySet);
        return contentVOS;
    }
}
