package com.example.demo.pingshi.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author zhangyu
 * @description 临时测试生产者
 * @date 2020-09-02 22:39
 */

public class TestProducer {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 3000; i++) {
            JSONObject obj = new JSONObject();
            obj.put("deviceId", i);
            obj.put("age", i * 2);
            producer.send(new ProducerRecord<String, String>("t3", "Message" + i, JSONObject.toJSONString(obj)));
            System.out.println("已发送..");
            Thread.sleep(1500);
        }
        producer.close();
    }
}
