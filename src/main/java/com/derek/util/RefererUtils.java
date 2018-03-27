package com.derek.util;

/**
 * @author Derek
 * @date 2018/3/25 11:54
 */

public class RefererUtils {

    /**
     * 获取当前编辑商品的id
     *
     * @param referer
     * @return
     */
    public static int getRefererId(String referer) {
        int index = referer.indexOf("id=");
        return Integer.parseInt(referer.substring(index + 3));
    }

    /**
     * 判断当前是否是在编辑情况下上传照片
     *
     * @param referer
     * @return
     */
    public static boolean isEdit(String referer) {
        return referer.contains("edit");
    }

    public static void main(String[] args) {
        String testURL = "http://127.0.0.1:8000/edit?id=2";
        System.out.println(getRefererId(testURL));
    }
}
