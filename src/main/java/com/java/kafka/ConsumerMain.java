package com.java.kafka;

/**
 * @description:
 * @author: ws
 * @time: 2020/5/10 15:36
 */
public class ConsumerMain {

    public static void main(String[] args) {
        String brokerList = "192.168.31.9:9092";
        String topic = "topic_partition12";
        String group = "group-1";

        int workerNum = 4;

        ConsumerHandler consumers = new ConsumerHandler(brokerList, topic, group);
        consumers.execute(workerNum);

    }

}
