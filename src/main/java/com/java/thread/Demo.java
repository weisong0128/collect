package com.java.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: java异步调用-即利用多线程
 * 同步调用：调用方在调用过程中，持续等待返回结果。
   异步调用：调用方在调用过程中，不直接等待返回结果，而是执行其他任务，结果返回形式通常为回调函数。
 * @author: ws
 * @time: 2020/9/1 16:54
 */

public class Demo {
    //异步线程方法三：调用线程池
    private static ThreadPoolExecutor threadPool;

    public static void main(String[] args) {
        System.out.println("main函数开始执行");

        //异步线程方法一：直接创建一个线程
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
            }
        });
        thread.start();*/

        //或者
        //Thread thread = new Thread(new Student("haha"));
        //thread.start();

        //异步线程方法二：创建一个对象，这个类继承了Thread
        /*Student s = new Student("haha");
        s.run();*/

        //异步线程方法三：使用线程池异步调用
        threadPool = new ThreadPoolExecutor(10,20,1, TimeUnit.MINUTES, new LinkedBlockingDeque<>());
        //创建两个额外线程，这两个线程也是异步的，没有同步顺序关系
        /*for (int i = 0; i < 2; i++) {
            threadPool.execute(new Student(String.valueOf(i)));
        }*/
        //只创建一个额外线程
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
            }
        });
        //也可以用submit 一样的
        /*threadPool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("===task start===");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
            }
        });*/


        System.out.println("main函数执行结束");

    }

}
