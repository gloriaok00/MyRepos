package com.example.demo.pingshi.kafka.sw;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 平台kafka连接
 *
 * @author zhangyu
 * @date 2020/08/24 10:48
 */
public class TestConnection {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "118.113.164.51:25705");
        //props.put("bootstrap.servers", "39.100.14.20:31090");
        props.put("group.id", "0");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        Set topicSet = consumer.listTopics().keySet();
        List<String> topicList = new ArrayList<>(topicSet);
        List<String> outboundTopicList = topicList.stream().filter(topic -> topic.contains(".outbound-events")).collect(Collectors.toList());
        System.out.println("subscribedTopic:" + outboundTopicList);
        consumer.subscribe(outboundTopicList);
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }

}
