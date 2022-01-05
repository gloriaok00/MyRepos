package com.example.demo.pingshi.kafka.baseconception;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author zhangyu
 * @description kafka基本概念 单个
 * @date 2020-09-02 22:36
 */
public class CConsumer {

    public static void main(String[] args) throws Exception {
        OutputStream outStream = new FileOutputStream(new File("./src/main/resources/c0.txt"));

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "zydemo");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("t1", "t2"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                outStream.write(String.format("%s,%s,%s,%s", record.value(), record.partition(), record.topic(), "\n").getBytes());
            }
        }
    }
}
