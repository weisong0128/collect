package com.java.kafka;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 描述
 * @author: ws
 * @time: 2020/4/16 14:11
 */

public class ConsumerHighAPITest {
    //创建线程池及对象
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
    public static void main(String[] args) {
        String topic = "ws_topic_02";
        int threads = 1;
        String zookeeper = "192.168.74.9:2181";
        String groupId = "group_0416";

        ConsumerHighAPI api = new ConsumerHighAPI(topic,threads,zookeeper,groupId); //这里只是说最多启动threads=1个线程，并不代表启了1个线程

        new Thread(api).start();    //这个start()写几次，代表异步有几个线程执行

    }


}
