package com.java.kafka;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.*;

/**
 * @description: 自定义简单kafka消费者，使用高级API:将底层具体获取数据、更新offset、设置偏移量等操作屏蔽
 * 直接将操作数据流的处理工作提供给编写程序的人员。
 * 优点是：操作简单；缺点：可操作性太差，无法按照自己业务场景选择处理方式
 * 入口类：ConsumerConnector
 * @author: ws
 * @time: 2020/4/16 9:52
 */

public class ConsumerHighAPI implements Runnable{
    //kafka数据消费实例化对象
    private ConsumerConnector consumer;
    //kafka topic名称
    private String topic;
    //线程数量，一般就是topic的分区数量
    private int numThreads;
    //线程池
//    private ExecutorService executorPool;
    //创建线程池及对象
    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,1, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());

    /**
     * 构造函数
     * @param topic          topic名
     * @param numThreads    处理数据的线程数/可以理解为topic的分区数
     * @param zookeeper     kafka的zookeeper连接字符串
     * @param groupId       该消费者所属group id的值
     */
    public ConsumerHighAPI (String topic, int numThreads, String zookeeper, String groupId) {
        //1.创建kafka连接器
        this.consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(zookeeper, groupId));
        //2.实例化时，参数赋值，将这些可变的参数值通过new实例化时，直接传在构造函数中，而不用传在方法中
        this.topic = topic;
        this.numThreads = numThreads;
    }


    @Override
    public void run() {
        //1.指定topic
        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put(this.topic, this.numThreads);

        //2.指定数据的解码器
        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

        //3.kafka连接器对象调用createMessageStreams方法，获取连接数据的迭代器对象
        Map<String, List<KafkaStream<String, String>>> messageStreams = this.consumer.createMessageStreams(topicMap, keyDecoder, valueDecoder);

        //4.从返回结果中获取对应topic的数据流处理器
        List<KafkaStream<String, String>> streams = messageStreams.get(this.topic);

        //5.创建线程池
//        executorPool = Executors.newFixedThreadPool(this.numThreads);

        //6.构建数据输出对象
        int threadNumber = 0;
        for (KafkaStream<String, String> stream : streams) {
//            threadPool.submit(new ConsumerKafkaStreamProcesser(stream, threadNumber));
            new ConsumerKafkaStreamProcesser(stream, threadNumber);
            threadNumber++;
        }

    }

    /**
     * 根据传入的zk的连接信息和groupId的值创建对应的ConsumerConfig对象
     * @param zookeeper
     * @param groupId
     * @return kafka连接信息
     */
    private ConsumerConfig createConsumerConfig(String zookeeper, String groupId) {
        //1.构建属性对象
        Properties props = new Properties();
        //2.添加相关配置属性
        props.put("group.id", groupId);
        props.put("zookeeper.connect", zookeeper);
        props.put("zookeeper.session.timeout.ms", "400");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        //3.构建ConsumerConfig对象
        return new ConsumerConfig(props);
    }

    public static class ConsumerKafkaStreamProcesser implements Runnable {
        //kafka数据流
        private KafkaStream<String, String> stream;
        //线程ID编号
        private int threadNumber;

        public ConsumerKafkaStreamProcesser(KafkaStream<String, String> stream, int threadNumber) {
            this.stream = stream;
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            //1.获取数据迭代器
            ConsumerIterator<String, String> iter = this.stream.iterator();
            //2.迭代输出数据
            while (iter.hasNext()) {
                //获取数据值
                MessageAndMetadata<String, String> value = iter.next();

                //输出
                System.out.println(this.threadNumber + ":"  + value.offset() + ":" + value.key() + ":" + value.message());
            }
            //3.表示当前线程执行完成
            System.out.println("线程完成：" + this.threadNumber);
        }
    }

}
