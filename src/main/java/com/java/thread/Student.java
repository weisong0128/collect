package com.java.thread;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/9/1 17:03
 */

public class Student implements Runnable{

    public Student(String str) {
        System.out.println("str=" + str);
    }


    @Override
    public void run() {
        System.out.println("===task start===");
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===task finish===");
    }
}
