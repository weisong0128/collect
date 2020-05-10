package com.java.kafka.old;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 这种是多消费实例模式
 * @author: ws
 * @time: 2020/5/10 20:36
 */
public class ConsumerThread implements Runnable{
    private static Properties properties;
    private KafkaConsumer<String, String> consumer;

    private static ThreadPoolExecutor threadPool;

    private String topic;

    public ConsumerThread(String topic) {
        this.topic = topic;
    }

    static {
        properties = new Properties();
        properties.put("bootstrap.servers", "192.168.31.9:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


    }

    /*public void getMessage() {
        //实例化Consumer对象
        consumer = new KafkaConsumer<String, String>(properties);

        //订阅主题tipic
        consumer.subscribe(Collections.singleton(this.topic));

        threadPool = new ThreadPoolExecutor(4,4,1, TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>());
        while(true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println("线程为：" + Thread.currentThread().getName() + ",partition = " + record.partition() + ",offset = " + record.offset() + ",record.value() = " + record.value()
                        + "----------consumer = " + consumer.toString());
                //关键点在这，多线程每次处理一个消息 通过submit方法随机选用一个线程去执行task任务（也就是下面括号内的方法）
                //比如：我们一次poll拉取1000个缓存引用变量records，通过循环进行依次处理，然而每次处理分配到的线程是可变的，这里就是多线程
                //这里封装了具体的业务处理逻辑
                //1000个record就要1000个线程（从线程池里取）依次处理
//                threadPool.submit(new task(record));
            }
        }
    }*/


    @Override
    public void run() {
        //实例化Consumer对象
        consumer = new KafkaConsumer<String, String>(properties);

        //订阅主题tipic
        consumer.subscribe(Collections.singleton(this.topic));

        threadPool = new ThreadPoolExecutor(4,4,1, TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>());
        while(true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println("线程为：" + Thread.currentThread().getName() + ",partition = " + record.partition() + ",offset = " + record.offset() + ",record.value() = " + record.value()
                        + "----------consumer = " + consumer.toString());
                //关键点在这，多线程每次处理一个消息 通过submit方法随机选用一个线程去执行task任务（也就是下面括号内的方法）
                //比如：我们一次poll拉取1000个缓存引用变量records，通过循环进行依次处理，然而每次处理分配到的线程是可变的，这里就是多线程
                //这里封装了具体的业务处理逻辑
                //1000个record就要1000个线程（从线程池里取）依次处理
//                threadPool.submit(new task(record));
            }
        }


    }
}
