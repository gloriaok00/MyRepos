package com.example.demo.pingshi.kafka;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.session.Book;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author zhangyu
 * @description
 * @date 2020-07-10 13:05
 */

public class MyProducer {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i=0;i<100;i++){
            Book tempBook=new Book(i,i+"书");
            HashMap myMap=new HashMap();
            myMap.put("version","2020年再版");
            Shop shop=new Shop(i,"用户"+i,tempBook,myMap);
            producer.send(new ProducerRecord<String, String>("t1","Message"+i,JSONObject.toJSONString(shop)));
            System.out.println("已发送..");
            Thread.sleep(1500);
        }
        producer.close();
    }
}
