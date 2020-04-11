package com.java.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description: 主线程，当所有线程干完后，运行执行通过await()方法
 * @author: ws
 * @time: 2020/3/31 20:02
 */

public class Boss implements Runnable {
    private CountDownLatch countDownLatch;

    public Boss(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("老板正等所有的工人干完活");
        try {
            //一直在等待(阻塞)，直到countDownLatch计数为0，其他线程完成各
            // 自的任务，这个主进程就能通过await()方法,接着执行下面的代码
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("工人活都干完了，老板开始检查了！");
    }
}
