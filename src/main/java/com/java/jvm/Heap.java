package com.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: java垃圾回收过程		演示
 * @author: ws
 * @time: 2020/5/17 23:44
 */
public class Heap {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        boolean flag = true;
        while(flag) {
            try {
                i++;
                list.add(new byte[1*1024*1024]);    //每次增加1MB大小的数组对象
                Thread.sleep(60);
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
                System.out.println("Count = " + i); //记录运行的次数

            }


        }


    }

}
