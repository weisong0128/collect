package com.java.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * description: 客户端消费消息
 * author: ws
 * time: 2020/4/12 11:03
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //1.创建出链接工厂对象
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.31.9");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        //2.通过链接工厂创建出链接对象
        Connection connection = factory.newConnection();
        //3.通过链接对象创建channel
        Channel channel = connection.createChannel();
        //4.创建出消息队列
        String queueName = "test001";
        /**
         * 第一个参数：消息队列的名称
         * 第二个参数：消息是否持久化
         * 第三个参数：channel是否独占消息队列
         * 第四个参数：是否自动删除消息队列，当消息队列没有绑定交换机时是否自动删除
         * 第五个参数：扩展参数
         */
        channel.queueDeclare(queueName,true,false,false,null);
        //5.创建出消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //6.通过channel把消费者和消息队列进行关联
        channel.basicConsume(queueName,true,consumer);
        //7.获取消息，对消息进行处理
        for(;;){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.out.println("消费端获取到消息：" + msg);
        }

    }

}
