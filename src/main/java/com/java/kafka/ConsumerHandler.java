package com.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 消费者代码 ，这其实是单kafkaconsumer多work模式
 * @author: ws
 * @time: 2020/5/10 15:11
 */
public class ConsumerHandler {
    private static Properties properties;

    private KafkaConsumer<String, String> consumer;

    private ThreadPoolExecutor threadPool;

    public ConsumerHandler(String brokerList, String topic, String group) {
        properties = new Properties();
        InputStream resourceAsStream = ConsumerHandler.class.getClassLoader().getResourceAsStream("config/consumer.properties");

        try {
            properties.load(resourceAsStream);
            properties.setProperty("bootstrap.servers", brokerList);
            properties.setProperty("topic", topic);
            properties.setProperty("group.id", group);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //加载配置
        consumer = new KafkaConsumer<String, String>(properties);
        //订阅topic主题
        consumer.subscribe(Arrays.asList(topic));

    }

    /**
     * kafka拉取消息
     * @param workNum  线程数
     */
    void execute(int workNum) {

        //通过线程池实例化线程对象
        threadPool = new ThreadPoolExecutor(workNum, workNum, 1L, TimeUnit.MINUTES,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy());

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            for (ConsumerRecord<String, String> record : records) {
                threadPool.submit(new Worker(record, consumer));
            }
//            consumer.commitSync();

        }

    }


    public void shutdown() {
        if(consumer != null) {
            consumer.close();
        }
        if (threadPool != null) {
            threadPool.shutdown();
        }


    }







}
