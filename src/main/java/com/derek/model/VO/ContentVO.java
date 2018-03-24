package com.derek.model.VO;

import com.derek.model.Content;
import com.derek.model.Order;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * Content的VO对象
 * 在Content基础上包装了一些字段
 *
 * @author Derek
 * @date 2018/3/21 23:06
 */
@Data
public class ContentVO {

    private Integer id;

    private String title;

    private String summary;

    private String detail;

    private String image;

    private BigDecimal price;

    private boolean isBuy;

    /**
     * 购买时间
     */
    private Date buyTime;

    /**
     * 购买时价格
     */
    private BigDecimal buyPrice;

    /**
     * 购买数量
     */
    private int num;

    public ContentVO() {
    }

    public ContentVO(Content content, boolean isBuy) {
        BeanUtils.copyProperties(content, this);
        this.isBuy = isBuy;
    }

    public static List<ContentVO> buildFromList(List<Content> contents, HashSet<Integer> buySet) {
        List<ContentVO> contentVOS = new ArrayList<ContentVO>(contents.size());
        for (Content content : contents) {
            if (buySet.contains(content.getId())) {
                contentVOS.add(new ContentVO(content, true));
            } else {
                contentVOS.add(new ContentVO(content, false));
            }
        }
        return contentVOS;
    }

    public ContentVO(Content content, Order order) {
        BeanUtils.copyProperties(content, this);
        if (order == null) {
            this.isBuy = false;
        } else {
            this.isBuy = true;
            this.buyPrice = order.getPrice();
            this.buyTime = order.getGmtCreate();
            this.num = order.getNum();
        }
    }

}
