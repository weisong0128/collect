package com.java.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 生产者，往kafka中push数据
 * @author: ws
 * @time: 2020/4/15 14:12
 */

public class ProducerAPI {
    private static Properties props;
    private Producer<String, String> producer;

    static {
        props = new Properties();
        InputStream inputStream = ProducerAPI.class.getClassLoader().getResourceAsStream("config/producer.properties");
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String topic, String msg) {
        //实例化producer对象
        producer = new KafkaProducer<String, String>(props);

        //消息封装
        ProducerRecord<String, String> record = new ProducerRecord(topic,msg);

        //消息发送（生产）
        for (int i = 0; i < 5; i++) {
            producer.send(record);
        }
        System.out.println("kafka消息生产结束");

//        producer.close();
    }
}
