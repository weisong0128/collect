package com.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @description: 每个线程 task任务类：业务复杂逻辑处理代码
 * 一个消费者 多个线程“同时”进行并发处理
 * @author: ws
 * @time: 2020/5/10 15:05
 */
public class Worker implements Runnable{
    /**
     * 每批次消息记录
     */
    private ConsumerRecord record;

    private KafkaConsumer<String, String> consumer;

    public Worker(ConsumerRecord record, KafkaConsumer<String, String> consumer) {
        this.record = record;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        //拿到record后，就是具体的业务处理
        System.out.println("线程为：" + Thread.currentThread().getName() + ",partition = " + record.partition() + ",offset = " + record.offset() + ",record.value()：" + record.value()
                + "----------consumer = " + consumer.toString());

    }
}
