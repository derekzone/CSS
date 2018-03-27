package com.derek.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Derek
 * @date 2018/3/25 22:33
 */
public interface FileService {
    /**
     * 删除文件
     *
     * @param path
     */
    public void delete(String path);

    /**
     * 写入文件
     *
     * @param multipartFile
     * @return 文件名
     */
    public String save(MultipartFile multipartFile);
}
