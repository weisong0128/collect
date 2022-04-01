package com.java.thread;


import java.util.concurrent.*;

/**
 * @description: 匿名内部类、lambda表达式实现多线程
 * @author: ws
 * @date: 2022-04-01 15:10
 **/
public class Demo01 {
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1,
            1,
            1, TimeUnit.MINUTES,
            new SynchronousQueue<>());

    public static void main(String[] args) {
        //1.调用runnable实现类对象，创建Thread类对象，实现多线程程序
        RunnableImpl one = new RunnableImpl();
        Thread t1 = new Thread(one);
        t1.start();
        System.out.println(Thread.currentThread().getName() + "===================");

        //2.简化代码，使用匿名内部类，实现多线程程序
        Runnable t2 = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建新线程222");
            }
        };
        new Thread(t2).start();

        //3.继续简化代码
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建新线程333");
            }
        }).start();

        //4.使用lambda表达式，实现多线程程序
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "创建新线程444");
        }).start();

        //5.使用Executors线程池
        //newFixedThreadPool调用的也是ThreadPoolExecutor
        ExecutorService executor = Executors.newFixedThreadPool(1); //这里填1,则只能调用一次submit,若多次调用submit则还是同一个线程执行
        RunnableImpl runnableImpl = new RunnableImpl();
        executor.submit(runnableImpl);
//        executor.submit(runnableImpl);    //若只给1个线程，则这里第二次调用submit还是同一个线程
        executor.shutdown();    //不关闭则程序会一直处于运行状态

        //6.使用线程池
        threadPool.execute(new RunnableImpl());
        //或者直接在()内写线程方法
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "创建新线程6666");

            }
        });
        threadPool.shutdown();  //关闭该线程，和executor.shutdown()一样

    }
}
