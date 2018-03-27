package com.derek.model.request;

import lombok.Data;

/**
 * @author Derek
 * @date 2018/3/27 11:53
 */
@Data
public class EditSubRequest {
    private int id;
    private String title;
    private String summary;
    private String image;
    private String detail;
    private double price;
}
