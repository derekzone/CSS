package com.derek.model.response;

import lombok.Data;

/**
 * @author Derek
 * @date 2018/3/25 23:23
 */
@Data
public class BaseResponse {
    private String message;
    private String result;
    private int code;

    public static BaseResponse fail() {
        BaseResponse response = new BaseResponse();
        response.setCode(400);
        response.setMessage("error");
        return response;
    }

    public static BaseResponse fail(String message) {
        BaseResponse response = new BaseResponse();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }

    public static BaseResponse success(String result) {
        BaseResponse response = new BaseResponse();
        response.setMessage("success");
        response.setCode(200);
        response.setResult(result);
        return response;
    }

    public static BaseResponse success() {
        BaseResponse response = new BaseResponse();
        response.setMessage("success");
        response.setCode(200);
        return response;
    }
}
