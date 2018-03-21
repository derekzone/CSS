package com.derek.model.response;

import lombok.Data;

/**
 * @author Derek
 * @date 2018/3/21 20:24
 */
@Data
public class BaseResponse<T> {
    private T data;

    private String message;

    private boolean success;

    private int code;

    public static BaseResponse success() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("OK");
        baseResponse.setCode(200);
        return baseResponse;
    }

    public static BaseResponse fail() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(false);
        baseResponse.setCode(0);
        baseResponse.setMessage("Something Wrong");
        return baseResponse;
    }

}
