package com.java.learn;

/**
 * description: 学习java -D[参数名] [程序名]
 * author: ws
 * time: 2019/12/12 13:38
 */

public class ParaConfDemo {

    public static void main(String[] args) {
        String flag = System.getProperty("para");   //配置-D后的参数名为Para 即：-DPara
        System.out.println(flag);   //此时flag值为null
        String flag1 = System.getProperty("para1");
        System.out.println(flag1);
    }

}
