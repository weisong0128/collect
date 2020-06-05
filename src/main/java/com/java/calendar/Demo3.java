package com.java.calendar;

import com.java.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * description:  任务跟踪模块用到的工具
 * author: ws
 * time: 2019/11/26 17:09
 */

public class Demo3 {

    public static void main(String[] args) {
        Date date = new Date();
        long timeStamp = date.getTime()/1000;    // 得到此刻的时间戳
        long time = TimeUtil.beforeFewDays(0);
        System.out.println(time);  //得到今天0点0刻的时间戳

        String s = UUID.randomUUID().toString();
        System.out.println("随机的uuid值为：" + s );  //随机的uuid值为：0e45bfe1-dcfa-45c3-81c0-9a3c4fe7ca0d
        System.out.println(s.replaceAll("-",""));   //  b28a60a513da40d1854c6d751668f140

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("format=" + format);

        String str = "2019-11-30";
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            String format1 = new SimpleDateFormat("yyyy-MM-dd").format(parse);
            System.out.println("parse=" + parse);
            System.out.println("format1=" + format1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long time1 = new Date().getTime();
        System.out.println("time1=" + time1);

        System.out.println("####################");
        String a = "青岛市:370200";
        System.out.println(a.substring(0,a.indexOf(":")));

        Map<String, Object> map = new HashMap();
//        map.get("asd");
        System.out.println("map.get(\"asd\")的值为：" + map.get("asd"));
        //错误写法  object.toString()方法,这种方法要注意的是object不能为null,否则会报NullPointException，一般别用这种方法。
        /*if (map.get("asd").toString().isEmpty()) {
            System.out.println("kongkong");
        } else {
            System.out.println("zzzzxzc");
        }*/
        //常用写法
        if (String.valueOf(map.get("asd")).equals("null")) {
            System.out.println("kongkong");
        } else {
            System.out.println("zzzzzz");
        }

    }

}
