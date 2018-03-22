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

    public List<Content> getAll();

    public List<ContentVO> getAllVO(HashSet<Integer> buySet);
}
