package com.java.demo;

import com.java.util.TimeUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * description: 根据指定的一个时间戳，获取这个月的起始时间戳和月底最终时间戳
 * author: ws
 * time: 2019/11/23 16:46
 */

public class Demo2 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        String createTime2 = "1574499098";
        long createTime = Long.parseLong(createTime2);
        System.out.println(createTime);
        String startStr = TimeUtil.long2String(createTime, "yyyyMM");
        Date startDate = TimeUtil.String2Date(startStr, "yyyyMM");
        Long startTimeStamp = startDate.getTime()/1000;
        System.out.println(startTimeStamp);

        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        String endStr = TimeUtil.Date2String(calendar.getTime(), "yyyyMM");
        Date endDate = TimeUtil.String2Date(endStr, "yyyyMM");
        Long endTimeStamp = endDate.getTime()/1000;
        System.out.println(endTimeStamp);


    }

}
