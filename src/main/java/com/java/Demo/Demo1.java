package com.java.Demo;

import com.java.util.TimeUtil;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * description:
 * author: ws
 * time: 2019/11/22 20:42
 */
public class Demo1 {

    public static void main(String[] args) {
        /**
         * SimpleDateFormat类格式化日期
         * SimpleDateFormat类就两个用途：将String转Date(parse方法)，和将Date转String(format方法)
         */
        Date date = new Date(); //date=现在的时间 ,机器都读得懂的时间
        long timeStamp = date.getTime();    //Date转成时间戳
        System.out.println("当前时间戳为：" + timeStamp);
        String yyyyMM = TimeUtil.long2String(timeStamp/1000, "yyyyMM"); //时间戳转为10位的
        System.out.println("yyyyMM = " + yyyyMM);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);  // dateStr = 2019-11-22 21:14:52  formate方法:将日期类型转成字符串类型
        System.out.println("dateStr = " + dateStr);
        System.out.println("========================================");

        /**
         * Calendar日期类
         */
        Calendar calendar = Calendar.getInstance(); //使用单例模式创建类的实例，只能存在这一个实例化对象被使用
        System.out.println("calendar.getTime() = " + calendar.getTime());   //结果为new Date()日期：Fri Nov 22 21:28:24 CST 2019
        System.out.println("当前年份：" + calendar.get(Calendar.YEAR));// --> year = 2019
        System.out.println("当前月份：" + (calendar.get(Calendar.MONTH)+1));   //month是从0开始，实际月份要在结果上+1
        System.out.println("今天是当前月的第几天：" + calendar.get(Calendar.DAY_OF_MONTH));    //得到当月的第几天
        System.out.println("Calendar.DATE = " + Calendar.DATE); //Calendar.DATE 单独用表示个常量=5

        calendar.setTime(new Date());   //表示calendar对象设置的开始时间是现在，此刻=Fri Nov 22 22:00:41 CST 2019
        calendar.add(Calendar.DATE, -24);   //表示calendar对象时间变成现在时间基础上的前24天
        System.out.println("24天前的此刻Date日期：" + calendar.getTime()); //得到24天前的Date日期
        calendar.set(calendar.HOUR_OF_DAY, 0);  //设置时间 0点
        calendar.set(calendar.MINUTE, 0);   //0分
        calendar.set(calendar.SECOND, 0);   //0秒
        System.out.println("24天前0点0分0秒的Date日期：" + calendar.getTime()); // = Tue Oct 29 00:00:00 CST 2019
        Date date1 = calendar.getTime();    //Date日期转成时间戳
        System.out.println("默认Date的getTime方法(13位时间戳)：" + date1.getTime());    // = 1572278400118

        String yyyyMM2 = TimeUtil.beforeFewMonth(-3);     // 此刻Date时间的前3个月，结果为年月形式： 201908
        System.out.println("yyyyMM2 = " + yyyyMM2 );
        System.out.println("========================================");


        /**
         * 由当前Date时间计算出，当前月的时间戳范围（10位）
         */
        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);   //表示设置时间是从date2时间开始
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        System.out.println(calendar2.getTime());
        Date timeStamp2 = calendar2.getTime();  //java上时间精度是毫秒，因此是13位时间戳
        Long startTime = timeStamp2.getTime()/1000; //得到当前月起始的时间戳
        System.out.println(startTime);

        //计算月末的时间戳,即下个月的开始
//        int value = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);
//        System.out.println("value" + value);
        calendar2.add(Calendar.MONTH,1);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(calendar2.getTime());
        Date timeStamp3 = calendar2.getTime();
        Long endTime = timeStamp3.getTime()/1000;   //Date的getTime()方法得到的是13位的时间戳
        System.out.println("endTime:" + endTime);        //可以提取成一个方法!

        System.out.println("========================================");


        System.out.println("TimeUtil.beforeFewDays(3):" + TimeUtil.beforeFewDays(3));


//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
//        Timestamp t = new Timestamp(endTime*1000);
//        System.out.println(sdf2.format(t));

//        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        ParsePosition pos = new ParsePosition(0);
//        Date strDate = sdf2.parse("2013-1-21 15:10:20", pos); //parse 将字符串类型转换为日期Date类型,这里string值格式要和上面pattern中格式一致
//        System.out.println(strDate);


//        List<String> partitions = TimeUtil.partitons("halfMonth");
//        System.out.println(partitions);


//        String yyyyMMdd = TimeUtil.Date2String(new Date(), "yyyyMMdd");
//        System.out.println(yyyyMMdd);


    }
}
