package com.java.util;


import org.springframework.util.DigestUtils;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/4/28 10:33
 */

public class MD5Util {
    private static final String prefix = "123456";

    public static String getMD5(String str) {
        String base = str + "/" + prefix;
        String result = DigestUtils.md5DigestAsHex(base.getBytes());
        return result;
    }

    public static void main(String[] args) {
        String weisong = MD5Util.getMD5("weisong");
        System.out.println("weisong=" + weisong);
    }


}
