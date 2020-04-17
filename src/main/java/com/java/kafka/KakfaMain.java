package com.java.kafka;

import org.junit.Test;

/**
 * @description: 生产、消费主入口
 * @author: ws
 * @time: 2020/4/15 16:21
 */

public class KakfaMain {

    @Test
    public void produceTest() {
        String topic = "ws_topic_04";

        StringBuilder msg = new StringBuilder("hello kafka003!" + System.currentTimeMillis());
        ProducerAPI producerAPI = new ProducerAPI();
        producerAPI.sendMessage(topic,msg.toString());
    }

    @Test
    public void consumeTest() {
        String topic = "ws_topic_04";
        ConsumerAPI ct = new ConsumerAPI();
        ct.getMessage(topic);
    }

}
