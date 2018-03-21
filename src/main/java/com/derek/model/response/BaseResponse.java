//package com.derek.model.response;
//
///**
// * @author Derek
// * @date 2018/3/21 20:24
// */
////@Data
//public class BaseResponse<T> {
//    private T data;
//
//    private String message;
//
//    private boolean success;
//
//    private int code;
//
//    public static BaseResponse success() {
//        BaseResponse baseResponse = new BaseResponse();
//        baseResponse.setSuccess(true);
//        baseResponse.setMessage("OK");
//        baseResponse.setCode(200);
//        return baseResponse;
//    }
//
//    public static BaseResponse fail() {
//        BaseResponse baseResponse = new BaseResponse();
//        baseResponse.setSuccess(false);
//        baseResponse.setCode(0);
//        baseResponse.setMessage("Something Wrong");
//        return baseResponse;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//}
