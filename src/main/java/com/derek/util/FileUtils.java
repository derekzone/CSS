package com.derek.util;

import java.text.SimpleDateFormat;

/**
 * @author Derek
 * @date 2018/3/27 10:51
 */
public class FileUtils {

    //TODO 有并发问题，待优化
    public static String genFileName(String suffix) {
        java.util.Date dt = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName = fmt.format(dt);
        fileName = fileName + "." + suffix;
        return fileName;
    }
}
