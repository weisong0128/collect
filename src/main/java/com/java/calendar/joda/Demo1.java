package com.java.calendar.joda;

import org.joda.time.DateTime;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @description: joda-time:与JDK自带的Calendar功能一致，提供了一组Java类包用于处理日期和时间，比Calendar更易用
 * @author: ws
 * @time: 2020/7/3 10:18
 */

public class Demo1 {

    public static void main(String[] args) {
        //获取当前时间
        DateTime dateTime = new DateTime(new Date());
        System.out.println("dateTime=" + dateTime);
        System.out.println(dateTime.toString("yyyyMMdd HH:mm:ss"));
        System.out.println(dateTime);

    }

}
