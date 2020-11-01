package com.example.demo.pingshi.siddhi.protobuf;

import io.siddhi.distribution.sample.grpc.Sweet;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo implements Runnable {
    private  KafkaProducer<String,Sweet> producer = null;

    private  String topic = null;

    public ProducerDemo(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", com.example.demo.pingshi.siddhi.protobuf.SweetSerializer.class);
        this.producer = new KafkaProducer<String, Sweet>(props);
        this.topic = topicName;
    }

    @Override
    public void run() {
        int messageNo = 1;
        try {
            for(;;) {
                Sweet.Builder grpc=Sweet.newBuilder();
                grpc.setName("zy");
                grpc.setPrice(100);
                Sweet msg = grpc.build();
                producer.send(new ProducerRecord<String, Sweet>(topic, "Message", msg));
                //生产了5条就打印
                if(messageNo%5==0){
                    System.out.println("发送的信息:" + msg.toString());
                }
                messageNo++;
//              Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }

    public static void main(String args[]) {
        ProducerDemo test = new ProducerDemo("t1");
        Thread thread = new Thread(test);
        thread.start();
    }
}