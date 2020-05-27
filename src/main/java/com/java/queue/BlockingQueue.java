package com.java.queue;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @description: 阻塞式线程安全队列，基于数组实现
 * @author: ws
 * @time: 2020/5/27 20:36
 */
public class BlockingQueue {
    private List<String> list = new ArrayList<>();      //代表当前队列
    private int maxSize;
    //自定义一把对象锁
    private Object lock = new Object();

    public BlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        System.out.println("线程" + Thread.currentThread().getName() +"已经初始化完成，大小为：" + this.maxSize);
        System.out.println("----------------------");
    }

    public void put(String element){
        synchronized (lock) {
            //判断当前队列有没有满
            try {
                if(this.list.size()==this.maxSize){
                    System.out.println("线程" + Thread.currentThread().getName() + "已经满了，put方法进入到等待状态...");
                    lock.wait();    //释放锁
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //队列没有满
            this.list.add(element);
            System.out.println("线程" + Thread.currentThread().getName() + "向队列中添加了元素：" + element);
            lock.notifyAll();
        }
    }

    public void take(){
        synchronized (lock) {
            //为空，阻塞
            if(this.list.size()==0){
                System.out.println("线程" + Thread.currentThread().getName() + "已经空了，take方法进入到等待状态...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //如果不为空
            String result = list.get(0);
            list.remove(0);
            System.out.println("线程" + Thread.currentThread().getName() + "取到了元素：" + result);
            //哥们，我这边取到了数据，是不是可以来存放数据
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(5);

        new Thread(() -> {
            blockingQueue.put("1");
            blockingQueue.put("2");
            blockingQueue.put("3");
            blockingQueue.put("4");
            blockingQueue.put("5");
            blockingQueue.put("6");
            blockingQueue.put("7");
            blockingQueue.put("8");

        }, "T1-put").start();

        new Thread(() -> {
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
            blockingQueue.take();
        }, "T2-take").start();


    }





}
