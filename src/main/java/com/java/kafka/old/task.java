package com.java.kafka.old;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * @description:
 * @author: ws
 * @time: 2020/5/10 21:15
 */
public class task implements Runnable {
    private ConsumerRecord<String, String> record;
    private KafkaConsumer<String, String> consumer;

    public task(ConsumerRecord<String, String> record, KafkaConsumer<String, String> consumer) {
        this.record = record;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        System.out.println("线程为：" + Thread.currentThread().getName() + ",partition = " + record.partition() + ",offset = " + record.offset() + ",record.value()：" + record.value()
        + "----------consumer = " + consumer.toString());
    }
}
