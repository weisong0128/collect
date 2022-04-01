package com.java.java2linux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.nio.ch.IOUtil;

import java.io.InputStream;

/**
 * @description: 测试远程调用服务器脚本
 * @author: ws
 * @date: 2022-04-01 15:26
 **/
public class ExecTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecTest.class);
//    private static final String finalCmd = "F:\\test123.bat";

    public static void main(String[] args) {
        String finalCmd = args[0];
        try {
            //windows环境
//            Process process = Runtime.getRuntime().exec(finalCmd);
            //linux环境
            Process process = Runtime.getRuntime().exec("/bin/sh " + finalCmd);
            InputStream inputStream = process.getInputStream();
//            String result = IOUtil.consumeStream(inputStream);
            if (process.waitFor() != 0){
//                String errorInfo = IOUtil.consumeStream(process.getErrorStream());
//                LOGGER.error("call command error:{}", errorInfo);
            }else {
//                LOGGER.info("call command success:{}", result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
