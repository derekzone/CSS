package com.derek.model.mapper;

import com.derek.model.Content;
import com.derek.model.VO.ContentVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 14:47
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface ContentMapper extends Mapper<Content> {

    //TODO result map
    @Select("SELECT c.id as id,num as num,title as title,summary as summary,detail as detail,image as image,c.price as price,o.price as buyPrice,gmt_create as buyTime FROM content c JOIN `order` o ON c.id = o.cid WHERE o.uid = #{uid}")
    public List<ContentVO> queryByUid(@Param("uid") int uid);

    @Select("SELECT * FROM content WHERE sid = #{sid}")
    public List<Content> queryBySid(@Param("sid") int sid);
}
