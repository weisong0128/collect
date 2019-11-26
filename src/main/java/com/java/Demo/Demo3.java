package com.java.Demo;

import com.java.util.TimeUtil;

import java.util.Date;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/26 17:09
 */

public class Demo3 {

    public static void main(String[] args) {
        Date date = new Date();
        long timeStamp = date.getTime()/1000;    // 得到此刻的时间戳
        long time = TimeUtil.beforeFewDays(0);
        System.out.println(time);  //得到今天0点0刻的时间戳
    }
}
