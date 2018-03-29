package com.derek.service.impl;

import com.derek.model.Content;
import com.derek.model.VO.ContentVO;
import com.derek.model.mapper.ContentMapper;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Cacheable(value = "content", key = "'all'")
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

    @Override
    public List<ContentVO> filterVO(HashSet<Integer> buySet, boolean isBuy) {
        List<Content> contents = getAll();
        List<ContentVO> contentVOS = new ArrayList<ContentVO>();
        if (isBuy) {
            for (Content content : contents) {
                if (buySet.contains(content.getId())) {
                    contentVOS.add(new ContentVO(content, true));
                }
            }
        } else {
            for (Content content : contents) {
                if (!buySet.contains(content.getId())) {
                    contentVOS.add(new ContentVO(content, false));
                }
            }
        }
        return contentVOS;
    }

    @Override
    @Cacheable(value = "content", key = "#id.toString()")
    public Content getById(int id) {
        return contentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ContentVO> queryVOByUid(int uid) {
        return contentMapper.queryByUid(uid);
    }

    @Override
    @Cacheable(value = "content", key = "#sid + ':seller'")
    public List<Content> queryBySid(int sid) {
        return contentMapper.queryBySid(sid);
    }

    @Override
    @CacheEvict(value = "content", key = "#id.toString()", allEntries = true)
    public boolean update(Content content) {
        return contentMapper.updateByPrimaryKeySelective(content) == 1;
    }

    @Override
    @CacheEvict(value = "content", allEntries = true)
    public void addContent(Content content) {
        contentMapper.insertGenId(content);
    }

    @Override
    @CacheEvict(value = "content", key = "#id.toString()", allEntries = true)
    public boolean delete(int id) {
        //TODO 图片删除
        return contentMapper.deleteByPrimaryKey(id) == 1;
    }
}
