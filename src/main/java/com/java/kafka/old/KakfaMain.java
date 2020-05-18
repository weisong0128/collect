package com.java.kafka.old;

import com.java.kafka.old.ConsumerAPI;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 生产、消费主入口
 * @author: ws
 * @time: 2020/4/15 16:21
 */

public class KakfaMain {
    private static final int THREAD_NUMBER = 8;
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,20,1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());


    public static void main(String[] args) {
//        String topic = "topic_partition12";
//        ConsumerAPI ct = new ConsumerAPI();
//        ct.getMessage(topic);


//        String topic = "topic_partition12";
//
//        StringBuilder msg = new StringBuilder("hello kafka012");
//        ProducerAPI producerAPI = new ProducerAPI();
//        producerAPI.sendMessage(topic,msg.toString());


        //多线程，多消费实例
        String topic = "topic_partition12";
        for (int i = 0; i < THREAD_NUMBER; i++) {
            threadPool.execute(new ConsumerThread(topic));
        }

        //多线程，单消费实例，多work
//        ConsumerThread2 consumerThread = new ConsumerThread2(topic);
//        consumerThread.getMessage();


    }





}
