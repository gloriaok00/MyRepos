package com.example.demo.pingshi.kafka;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author zhangyu
 * @description  siddhi kafkaMultiDCProducer
 * @date 2021-01-24 22:26
 */

public class kafkaMultiDCProducer {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i=0;i<30000;i++){
            JSONObject obj=new JSONObject();
            obj.put("symbol","aaa");
            obj.put("price",112.11);
            obj.put("volume",12232);
            /*
            这里由于siddhi 的 kafkaMultiDC为source时，如果发现message里没有sequence.id会把消息drop掉。所以即使不想加sequence.id
            也要把那里写成null才行。这里我配的是zy。格式如下：
            null:10~{"volume":12232,"symbol":"aaa","price":112.11}
             */
            producer.send(new ProducerRecord<String, String>("t17","Message"+i,"zy:"+i+"~"+JSONObject.toJSONString(obj)));
            System.out.println("已发送..");
            Thread.sleep(1500);
        }
        producer.close();
    }
}
