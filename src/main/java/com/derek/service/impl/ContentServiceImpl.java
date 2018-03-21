package com.derek.service.impl;

import com.derek.model.Content;
import com.derek.model.mapper.ContentMapper;
import com.derek.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:46
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public List<Content> getAll() {
        return contentMapper.selectAll();
    }
}
