package com.example.demo.pingshi.kafka.baseconception;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @author zhangyu
 * @description  kafka基本概念 正则表达式
 * @date 2020-10-07 20:31
 */
public class PatternConsumer {

    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "zydemo1111");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        Pattern pattern = Pattern.compile("t.*");
        consumer.subscribe(pattern, new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> arg0) {
                // TODO nothing：再均衡监听器会在之后的文章中进行讨论
            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> arg0) {
                // TODO nothing：再均衡监听器会在之后的文章中进行讨论
            }
        });
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(String.format("test1111:%s,%s,%s,%s", record.value(), record.partition(), record.topic(), "\n"));
            }
        }
    }
}
