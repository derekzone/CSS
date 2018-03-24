package com.derek.model.mapper;

import com.derek.model.Content;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Derek
 * @date 2018/3/21 14:47
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface ContentMapper extends Mapper<Content> {
}
