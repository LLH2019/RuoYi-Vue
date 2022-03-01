package com.ruoyi.common.mq;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author ：LLH
 * @date ：Created in 2022/2/28 10:11
 * @description：kafka 生产者
 */
@Component
public class KafkaMsgProducer {

    static KafkaProducer<String, String> producer;
    static {
        Properties props = new Properties();
        //kafka服务器地址
        props.put("bootstrap.servers", "localhost:9092");
        //设置数据key和value的序列化处理类
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        //创建生产者实例
        producer = new KafkaProducer<>(props);
    }
    public void sendKafkaMsg(KafkaMessage msg){
//        //配置信息
//        Properties props = new Properties();
//        //kafka服务器地址
//        props.put("bootstrap.servers", "localhost:9092");
//        //设置数据key和value的序列化处理类
//        props.put("key.serializer", StringSerializer.class);
//        props.put("value.serializer", StringSerializer.class);
//        //创建生产者实例
//        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord record = new ProducerRecord<String, String>(msg.getTopic(), msg.getKey(), msg.getValue());
        //发送记录
        producer.send(record);
//        producer.close();
    }

}
