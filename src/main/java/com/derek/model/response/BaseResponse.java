package com.derek.model.response;

/**
 * @author Derek
 * @date 2018/3/25 23:23
 */
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

    public static BaseResponse fail(String message, int code) {
        BaseResponse response = new BaseResponse();
        response.setCode(code);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", result='" + result + '\'' +
                ", code=" + code +
                '}';
    }
}
