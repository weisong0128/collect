package com.java.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @description: 消费者，从kafka中pull数据
 * @author: ws
 * @time: 2020/4/15 15:49
 */

public class ConsumerAPI {
    private static Properties properties;
    private KafkaConsumer<String, String> consumer;

    static {
        properties = new Properties();
        InputStream input = ConsumerAPI.class.getClassLoader().getResourceAsStream("config/consumer.properties");

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*properties = new Properties();
        properties.put("bootstrap.servers", "192.168.74.9:9092");
        properties.put("group.id", "group-1");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "earliest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");*/


    }

    public void getMessage(String topic) {
        //实例化Consumer对象
        consumer = new KafkaConsumer<String, String>(properties);

        //订阅主题tipic
//        consumer.subscribe(Arrays.asList(topic));
        consumer.subscribe(Collections.singleton(topic));
        while(true) {
            ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for (ConsumerRecord<String, String> record : consumerRecords) {
                System.out.printf("消费情况：partition = %d,offset = %d, key = %s, value = %s%n",record.partition(), record.offset(), record.key(), record.value());
                System.out.println();
            }
        }
    }
    /*public void closeConsumer() {
        consumer.close();
    }*/
}
