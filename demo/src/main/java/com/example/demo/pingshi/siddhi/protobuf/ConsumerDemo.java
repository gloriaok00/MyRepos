package com.example.demo.pingshi.siddhi.protobuf;

import io.siddhi.distribution.sample.grpc.Sweet;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo implements Runnable {
    private KafkaConsumer<String, Sweet> consumer;

    private ConsumerRecords<String, Sweet> msgList;

    private  String topic;

    private static final String GROUPID = "test-consumer-group";

    public ConsumerDemo(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUPID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", com.example.demo.pingshi.siddhi.protobuf.SweetDeserializer.class);
        this.consumer = new KafkaConsumer<String, Sweet>(props);
        this.topic = topicName;
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        int messageNo = 1;
        System.out.println("---------开始消费---------");
        try {
            for (;;) {
                msgList = consumer.poll(1000);
                if(null!=msgList&&msgList.count()>0){
                    for (ConsumerRecord<String, Sweet> record : msgList) {
                        //消费5就打印 ,但打印的数据不一定是这个规律的
                        if(messageNo%5==0){
                            Sweet msg = (Sweet)(record.value());
                            System.out.println(messageNo+"=======receive: key = " + record.key() + ", value = " + record.value().toString());
                        }
                        //当消费了1000条就退出
                        if(messageNo%1000==0){
                            break;
                        }
                        messageNo++;
                    }
                }else{
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void main(String args[]) {
        ConsumerDemo test1 = new ConsumerDemo("t1");
        Thread thread1 = new Thread(test1);
        thread1.start();
    }
}
