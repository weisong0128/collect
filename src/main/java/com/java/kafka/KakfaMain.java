package com.java.kafka;

import org.junit.Test;

/**
 * @description: 生产、消费主入口
 * @author: ws
 * @time: 2020/4/15 16:21
 */

public class KakfaMain {

    public static void main(String[] args) {
        String topic = "topic_0507";
        ConsumerAPI ct = new ConsumerAPI();
        ct.getMessage(topic);


//        String topic = "topic_0507";
//
//        StringBuilder msg = new StringBuilder("hello kafka003!" + System.currentTimeMillis());
//        ProducerAPI producerAPI = new ProducerAPI();
//        producerAPI.sendMessage(topic,msg.toString());

    }




    /*@Test
    public void produceTest() {
        String topic = "topic_0429";

        StringBuilder msg = new StringBuilder("hello kafka003!" + System.currentTimeMillis());
        ProducerAPI producerAPI = new ProducerAPI();
        producerAPI.sendMessage(topic,msg.toString());
    }

    @Test
    public void consumeTest() {
        String topic = "topic_0429";
        ConsumerAPI ct = new ConsumerAPI();
        ct.getMessage(topic);
    }*/

}
