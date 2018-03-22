package com.derek.model.mapper;

import com.derek.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Derek
 * @date 2018/3/21 09:37
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface UserMapper extends Mapper<User> {
    @Select(
            "SELECT * FROM user WHERE username = #{username} AND password = #{md5Password}"
    )
    public User verifyUser(@Param("username") String username, @Param("md5Password") String md5Password);
}
