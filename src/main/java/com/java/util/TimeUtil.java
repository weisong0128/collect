package com.java.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author fengxiaochun
 * @date 2019/7/4
 */
public class TimeUtil {

    // public static DateFormat format = new SimpleDateFormat("yyyyMMdd");
    private static  final int NUMBER_1000=1000;

    /**
     * 以此刻时间为准，得到days月前那一天0时0分0秒的时间戳
     * @param days
     * @return 时间戳（10位）
     */
    public static long beforeFewDays(int days) {
        Calendar calendar = Calendar.getInstance(); //日期类
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -days);
        calendar.set(Calendar.HOUR_OF_DAY, 0);  //设置时间 0点
        calendar.set(Calendar.MINUTE, 0);   //0分
        calendar.set(Calendar.SECOND, 0);   //0秒
        Date updateDate = calendar.getTime();
        return updateDate.getTime() / NUMBER_1000;
    }

    /**
     * 以此刻时间为准，得到month月前那一天0时0分0秒的时间戳
     * @param month
     * @return 时间戳（10位）
     */
    public static long beforeFewMonthLong(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -month);
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date updateDate = calendar.getTime();
        return updateDate.getTime() / NUMBER_1000;
    }

    /**
     * 以此刻Date时间为准，得到month月前那一月，格式为yyyyMM形式201909
     * @param month int型 表示n个月前，可以是当前月，也可以是几个月前
     * @return  以此刻为基准的n个月前，返回格式：201909
     */
    public static String beforeFewMonth(int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -month);
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date updateDate = calendar.getTime();
        return long2String(updateDate.getTime() / NUMBER_1000, "yyyyMM");
    }

    /**
     * yyyy-MM-dd HH:mm:ss格式的字符串日期转成时间戳（10位）
     * @param date
     * @return 时间戳（10位）
     */
    public static long String2Long(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //指定的格式为yyyy-MM-dd HH:mm:ss
        ParsePosition pos = new ParsePosition(0);
        Date strDate = format.parse(date, pos);
        return strDate.getTime() / NUMBER_1000;
    }

    /**
     * long型时间戳转指定日期样式输出
     * @param time 时间戳（10位）
     * @param format 自己指定的日期格式，如 yyyyMM yyyyMMdd
     * @return String类型日期
     */
    public static String long2String(long time, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);   //指定的格式为format
        Timestamp timestamp = new Timestamp(time * NUMBER_1000);
        return simpleDateFormat.format(timestamp);
    }

    /**
     * 封装beforeFewMonth()方法，以此刻时间为准，得到连续前month个月的List链表（字符串日期 201911）
     * @param month=3
     * @return [201911, 201910, 201909, 201908]
     */
    public static List<String> partitions(int month) {
        List<String> list = new ArrayList();
        for (int i = 0; i <= month; i++) {
            list.add(beforeFewMonth(i));
        }
        return list;
    }

    private static  final int NUMBER_7=7;
    private static  final int NUMBER_15=15;

    /**
     * 以今天为准，返回今天、7天前、15天前的日期（格式为yyyyMM）
     * @param dateTag 以今天20191123为例
     * @return "today"返回：[201911]  "seven":[201911]     "halfMonth":[201911]
     */
    public static List<String> partitons(String dateTag) {
        int day = new Date().getDate();
        List<String> list = new ArrayList();
        if (dateTag.equals("today")) {
            list = partitions(0);

        } else if (dateTag.equals("seven")) {
            if (day >= NUMBER_7) {
                list = partitions(0);
            } else {
                list = partitions(1);
            }

        } else if (dateTag.equals("halfMonth")) {
            if (day >= NUMBER_15) {
                list = partitions(0);
            } else {
                list = partitions(1);
            }

        } else {
        }
        return list;
    }
    public static List<String> getMonthByLong(Long start, Long end) {
        start = start * NUMBER_1000;
        end = end * NUMBER_1000;
        ArrayList<String> list = new ArrayList();
        try {
            DateFormat format = new SimpleDateFormat("yyyyMM");
            Calendar cal = Calendar.getInstance();
            Date startMonth = format.parse(format.format(new Date(start)));
            Date endMonth = format.parse(format.format(new Date(end)));
            cal.setTime(startMonth);
            while (true) {
                /*int year = cal.get(Calendar.YEAR);
                int momth = cal.get(Calendar.MONTH) + 1;*/
                String s = format.format(startMonth);
                if (startMonth.getTime() > endMonth.getTime()) {
                    break;
                }
                list.add(s);
                cal.add(Calendar.MONTH, 1);
                startMonth = cal.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Date型时间转指定格式日期
     * @param date  new date()
     * @param regex yyyyMMdd
     * @return  20191123
     */
    public static String Date2String(Date date, String regex) {
        DateFormat dateFormat = new SimpleDateFormat(regex);
        return dateFormat.format(date);
    }

    public static Date String2Date(String dateStr, String regex) {
        DateFormat dateFormat = new SimpleDateFormat(regex);
        Date parse = null;
        try {
            parse = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
    private static final  int NUMBER_12=12;
    public static  List<String> convertMonth(Long startTime,Long endTime){
       // List<String> list = new ArrayList<>();
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        //Calendar calendar = Calendar.getInstance();
        Integer startYear = Integer.valueOf(yearFormat.format(startTime));
        Integer endYear = Integer.valueOf(yearFormat.format(endTime));
        Integer startMonth = Integer.valueOf(monthFormat.format(startTime));
        Integer endMonth = Integer.valueOf(monthFormat.format(endTime));
        int count=0;
        if (startYear.equals(endYear)){
            count=endMonth-startMonth+1;
        }else {
            count=(endYear-startYear-1)*NUMBER_12+(endMonth+NUMBER_12-startMonth+1);
        }
        return  partitions(count);
    }
}
