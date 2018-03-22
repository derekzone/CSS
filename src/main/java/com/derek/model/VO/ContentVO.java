package com.derek.model.VO;

import com.derek.model.Content;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
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
}
