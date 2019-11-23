package com.java.Demo;

import com.java.util.TimeUtil;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.Date;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/23 16:46
 */

public class Demo2 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        String createTime2 = "1574499098";
        long createTime = Long.parseLong(createTime2);
        System.out.println(createTime);
        String yyyyMM = TimeUtil.long2String(createTime, "yyyyMM");
        Date date = TimeUtil.String2Date(yyyyMM, "yyyyMM");
        Long origin = date.getTime()/1000;
        System.out.println(origin);

        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        String yyyyMM1 = TimeUtil.Date2String(calendar.getTime(), "yyyyMM");
        System.out.println(yyyyMM1);
        Date date1 = TimeUtil.String2Date(yyyyMM1, "yyyyMM");
        System.out.println(date1.getTime()/1000);


    }

}
