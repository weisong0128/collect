package com.java.log4j2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * description: 学习slf4j标准及log4j2日志实现
 * author: ws
 * time: 2019/12/23 11:09
 */

public class UserLog4j2 {

    private static final Logger logger = LoggerFactory.getLogger(UserLog4j2.class.getName());

    public static void main(String[] args) {
        logger.error("当前时间戳" + new Date().getTime()/1000);  //在${logpath}/info/erp_error_%d{yyyy-MM-dd}-%i.log中记录这一条日志信息
        logger.warn("lalalala");    //在${logpath}/info/erp_warn_%d{yyyy-MM-dd}-%i.log中记录以上两条日志信息
        logger.info("weisong"); //在${logpath}/info/erp_info_%d{yyyy-MM-dd}-%i.log中记录以上三条日志信息
    }


}
