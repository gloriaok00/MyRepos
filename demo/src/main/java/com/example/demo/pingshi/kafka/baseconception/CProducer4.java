package com.example.demo.pingshi.kafka.baseconception;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author zhangyu
 * @description  kafka基本概念 集群
 * @date 2020-09-02 22:39
 */

public class CProducer4 {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("acks", "1");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i=0;i<1000;i++){
            producer.send(new ProducerRecord<String, String>("t4",String.valueOf(i),String.valueOf(i)));
            //System.out.println("已发送..");
           Thread.sleep(500);
        }
        producer.close();
    }
}
