package com.derek.exception;

/**
 * @author Derek
 * @date 2018/3/28 09:22
 */
public class BaseException extends RuntimeException {
    private int code;//状态码

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message) {
        super(message);
        this.code = 400;
    }

    public int getCode() {
        return code;
    }
}
