package com.java.concurrent.countdownlatch;

import com.java.util.TimeUtil;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @description: CountDownLatch计数器使用案例,通过Executors.newCachedThreadPool()方法调用
 * 现在不推荐Executors工厂(ExecutorService)创建线程池(存在内存溢出的风险)，都使用ThreadPoolExecutor创建线程池
 * @author: ws
 * @time: 2020/3/31 20:06
 */

public class CountDownLatchTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(3);  //实例化一个倒计时器，计数个数为3

        Worker person1 = new Worker(countDownLatch, "张三");
        Worker person2 = new Worker(countDownLatch, "李四");
        Worker person3 = new Worker(countDownLatch, "王五");

        Boss boss = new Boss(countDownLatch);
        //execute()方法：提交任务交给线程池运行
        executor.execute(person3);  //每个人run()方法最后都执行一次countDown()方法，计数减一
        executor.execute(person2);
        executor.execute(person1);
        executor.execute(boss); //主线程必须在启动其他线程后立即调用CountDownLatch.await()方法。

        executor.shutdown();

    }

}
