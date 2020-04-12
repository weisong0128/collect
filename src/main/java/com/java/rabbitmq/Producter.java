package com.java.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * description: 客户端生产消息
 * author: ws
 * time: 2020/4/12 10:50
 */
public class Producter {
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
        //4.通过channel发布消息
        String msg = "hello rabbitmq!!!";
        //四个参数
        /**
         * 第一个参数：交换机名称
         * 第二个参数：路由键
         * 第三个参数：消息的额外属性
         * 第四个参数：消息的内容
         */
        for (int i = 0; i < 5; i++) {
            channel.basicPublish("","test001",null,msg.getBytes());
        }

        //5.释放资源
        channel.close();
        connection.close();
    }

}
