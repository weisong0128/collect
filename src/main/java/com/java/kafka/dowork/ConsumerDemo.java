package com.java.kafka.dowork;

import com.java.rabbitmq.Consumer;
import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: 使用多线程增加kafka消费能力，方法二
 * @author: ws
 * @time: 2020/5/10 15:56
 */
public class ConsumerDemo extends ShutdownableThread{
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            10,
            10,
            1,
            TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    private SynchronousQueue<ConsumerRecord<String, String>> pipelineQueue =
            new SynchronousQueue<ConsumerRecord<String, String>>();

    private KafkaConsumer<String, String> consumer;

    private String topic;


    /**
     * 业务处理逻辑
     * @param record
     */
    void processRecordItem(ConsumerRecord<String, String> record) {


    }











    public ConsumerDemo(String name, boolean isInterruptible) {
        super(name, isInterruptible);
    }

    @Override
    public void doWork() {
        consumer.subscribe(Arrays.asList(topic));
        ConsumerRecords<String, String> records = consumer.poll(1000);

        if (null == records || records.count() <= 0) return;

        for (ConsumerRecord<String, String> record : records) {
            processRecordItem(record);
        }


    }
}
