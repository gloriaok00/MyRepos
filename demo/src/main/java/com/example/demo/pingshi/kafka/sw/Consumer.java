package com.example.demo.pingshi.kafka.sw;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.kafka.sw.pojo.EventMessage;
import com.example.demo.pingshi.kafka.sw.pojo.Guuid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.util.JsonFormat;
import com.sitewhere.grpc.model.CommonModel;
import com.sitewhere.grpc.model.DeviceEventModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;

/**
 * @author zhangyu
 * @description 模拟消费kafka sw enrichedEvent payload 并往自己的topic里分发
 * @date 2020-08-23 14:30
 */

public class Consumer implements Runnable {
    private KafkaConsumer<String, DeviceEventModel.GEnrichedEventPayload> consumer;
    private KafkaProducer<String, String> producer;

    private ConsumerRecords<String, DeviceEventModel.GEnrichedEventPayload> msgList;

    private String topicCosumer;

    private static final String GROUPID = "test-consumer-group";
    private Gson gson;

    public void initConsumer(String topicName) {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.0.25:9092");
        //props.put("bootstrap.servers", "39.100.14.20:30023");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUPID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", com.example.demo.pingshi.kafka.sw.GEnrichedEventPayloadDeserializer.class);
        this.consumer = new KafkaConsumer<String, DeviceEventModel.GEnrichedEventPayload>(props);
        this.topicCosumer = topicName;
        this.consumer.subscribe(Arrays.asList(topicCosumer));
    }

    public void initProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUPID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(props);
    }

    @Override
    public void run() {
        try {
            while (true) {
                msgList = consumer.poll(20);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, DeviceEventModel.GEnrichedEventPayload> record : msgList) {
                        DeviceEventModel.GEnrichedEventPayload msg = record.value();
                        String jsonStr = JsonFormat.printer().print(msg);
                        JSONObject obj = JSONObject.parseObject(jsonStr);
                        EventMessage eventMessage = JSONObject.toJavaObject(obj, EventMessage.class);

                        String jsonString = gson.toJson(eventMessage);
                        System.out.println("json消息:");
                        System.out.println(jsonString);

                        UUID deviceId = asApiUuid(msg.getContext().getDeviceId());
                        String topic = String.format("cep-tenant-default-deviceId-%s", deviceId);
                        producer.send(new ProducerRecord<String, String>(topic, "Message", jsonString));
                        //System.out.println("单次结束");
                        Thread.sleep(5000);
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            producer.close();
        }
    }

    public static void main(String args[]) {
        System.out.println("sw consumer main start..");
        Consumer consumer = new Consumer();
        consumer.initGson();
        consumer.initConsumer("t1");
        consumer.initProducer();
        Thread thread1 = new Thread(consumer);
        thread1.start();
    }

    public static UUID asApiUuid(CommonModel.GUUID grpc) {
        if (grpc == null) {
            return null;
        }
        return new UUID(grpc.getMsb(), grpc.getLsb());
    }

    public void initGson() {
        GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(Guuid.class, new CustomGuuidSerializer());
        gsonBuilder.registerTypeAdapter(Long.class,new CustomDateSerializer());
        gson = gsonBuilder.create();
    }
}