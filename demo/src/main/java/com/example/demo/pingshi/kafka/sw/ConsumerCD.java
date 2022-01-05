package com.example.demo.pingshi.kafka.sw;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.kafka.sw.pojo.EventMessage;
import com.example.demo.pingshi.kafka.sw.pojo.Guuid;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.util.JsonFormat;
import com.sitewhere.grpc.model.CommonModel;
import com.sitewhere.grpc.model.DeviceEventModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @description 消费kafka sw enrichedEvent payload 并往自己的topic里分发
 * @date 2020-09-02 16:42
 */

@Slf4j
public class ConsumerCD implements Runnable {
    private KafkaConsumer<String, DeviceEventModel.GEnrichedEventPayload> consumer;
    private KafkaProducer<String, String> producer;

    private ConsumerRecords<String, DeviceEventModel.GEnrichedEventPayload> msgList;

    private static final String GROUPID = "iot-consumer-group";
    private Gson gson;

    public void initConsumer() {
        Properties props = new Properties();
        //props.put("bootstrap.servers", "192.168.0.25:30005");
        props.put("bootstrap.servers", "118.113.164.51:25705");
        //props.put("bootstrap.servers", "39.100.14.20:31092");
        //props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", GROUPID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", GEnrichedEventPayloadDeserializer.class);
        this.consumer = new KafkaConsumer<String, DeviceEventModel.GEnrichedEventPayload>(props);
        Set topicSet = consumer.listTopics().keySet();
        List<String> topicList = new ArrayList<>(topicSet);
        List<String> outboundTopicList = topicList.stream().filter(topic -> topic.contains(".outbound-events")).collect(Collectors.toList());
        log.info("subscribedTopic:" + outboundTopicList);
        this.consumer.subscribe(outboundTopicList);
    }

    public void initProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "39.100.14.20:9092");
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
                        log.info("json消息:");
                        log.info(jsonString);

                        UUID deviceId = asApiUuid(msg.getContext().getDeviceId());
                        String topic = String.format("cep-tenant-%s-deviceId-%s", getSubStr(record.topic(), "sitewhere.sitewhere.tenant.(.*?).outbound-events"), deviceId);
                        log.info("子topic:" + topic);
                        producer.send(new ProducerRecord<String, String>(topic, "Message", jsonString));
                        //System.out.println("单次结束");
                        //Thread.sleep(5000);
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
        log.info("sw consumer main start..");
        ConsumerCD consumer = new ConsumerCD();
        consumer.initGson();
        consumer.initConsumer();
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
        gsonBuilder.registerTypeAdapter(Long.class, new CustomDateSerializer());
        gson = gsonBuilder.create();
    }

    public static String getSubStr(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(1);
        }
        return soap;
    }
}
