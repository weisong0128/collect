package com.java.concurrent.countdownlatch;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @description: CountDownLatch计数器使用案例,通过ThreadPoolExecutor调用
 * 推荐这种线程池方式
 * corePoolSize:程序能同时使用的最大线程数是corePoolSize个线程,一般new几个线程对象必须要等于小于这个核心线程数量，这样new的线程对象才能一起干活
 * @author: ws
 * @time: 2020/4/1 10:13
 */

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,1, TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>());

        CountDownLatch countDownLatch = new CountDownLatch(3);  //实例化一个倒计时器，计数个数为3

        Worker person1 = new Worker(countDownLatch, "张三");
        Worker person2 = new Worker(countDownLatch, "李四");
        Worker person3 = new Worker(countDownLatch, "王五");

        Boss boss = new Boss(countDownLatch);
        threadPool.execute(person3);  //每个人run()方法最后都执行一次countDown()方法，计数减一
        threadPool.execute(person2);
        threadPool.execute(person1);
        threadPool.execute(boss); //主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。

        threadPool.shutdown();

        //使用多线程案例2：通过for循环指定线程数量
        /*int threadNumber = 5;
        for (int i = 0; i < threadNumber; i++) {
            threadPool.execute( new Worker(countDownLatch, "张三"));
        }*/


    }

}
