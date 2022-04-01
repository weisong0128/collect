package com.java.thread;

/**
 * @description:
 * @author: ws
 * @date: 2022-04-01 15:11
 **/
public class RunnableImpl implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建新线程111");
    }
}
