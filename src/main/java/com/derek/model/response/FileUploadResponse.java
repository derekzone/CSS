package com.derek.model.response;

import lombok.Data;

/**
 * @author Derek
 * @date 2018/3/25 23:23
 */
@Data
public class FileUploadResponse {
    private String message;
    private String result;
    private int code;

    public static FileUploadResponse fail() {
        FileUploadResponse response = new FileUploadResponse();
        response.setCode(400);
        response.setMessage("error");
        return response;
    }

    public static FileUploadResponse fail(String message) {
        FileUploadResponse response = new FileUploadResponse();
        response.setCode(400);
        response.setMessage(message);
        return response;
    }

    public static FileUploadResponse success(String result) {
        FileUploadResponse response = new FileUploadResponse();
        response.setMessage("success");
        response.setCode(200);
        response.setResult(result);
        return response;
    }
}
