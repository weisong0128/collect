package com.java.concurrent.countdownlatch;

import com.java.util.TimeUtil;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: 创建任务（线程）
 * @author: ws
 * @time: 2020/3/31 19:39
 */

public class Worker implements Runnable {
    private CountDownLatch countDownLatch;
    private String name;

    public Worker(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        doWork();
        try {
//            TimeUnit.SECONDS.sleep(new Random().nextInt(10));   //线程暂停[0,10)秒
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + "活干完了");
        countDownLatch.countDown(); //计数减一
    }

    private void doWork() {
        System.out.println(this.name + "正在干活");
    }
}
