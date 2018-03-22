package com.derek.model.mapper;


import com.derek.model.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Derek
 * @date 2018/3/21 23:13
 */
@org.apache.ibatis.annotations.Mapper
@Component
public interface OrderMapper extends Mapper<Order> {

    @Select(
            "SELECT DISTINCT o.cid FROM `order` AS o WHERE o.uid = ${uid}"
    )
    public List<Integer> getBuySet(@Param("uid") int uid);

    @Select(
            "SELECT * FROM `order` WHERE uid = ${uid}"
    )
    public List<Order> getOrderBuyUid(@Param("uid") Integer uid);
}
