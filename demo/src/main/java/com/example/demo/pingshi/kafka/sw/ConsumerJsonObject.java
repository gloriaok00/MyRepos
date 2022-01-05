package com.example.demo.pingshi.kafka.sw;

import com.alibaba.fastjson.JSONObject;
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

public class ConsumerJsonObject implements Runnable {
    private KafkaConsumer<String, DeviceEventModel.GEnrichedEventPayload> consumer;
    private KafkaProducer<String, String> producer;

    private ConsumerRecords<String, DeviceEventModel.GEnrichedEventPayload> msgList;

    private String topicCosumer;

    private static final String GROUPID = "test-consumer-group";

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
        props.put("value.deserializer", GEnrichedEventPayloadDeserializer.class);
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
            JSONObject obj = new JSONObject();
            //context
            JSONObject context = new JSONObject();
            JSONObject deviceStatus = new JSONObject();
            //event
            JSONObject event = new JSONObject();
            JSONObject measurement = new JSONObject();
            JSONObject subevent = new JSONObject();
            while (true) {
                msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, DeviceEventModel.GEnrichedEventPayload> record : msgList) {
                        DeviceEventModel.GEnrichedEventPayload msg = (DeviceEventModel.GEnrichedEventPayload) (record.value());
                       /*
                        System.out.println(record.value().toString());
                        String jsonStr = JsonFormat.printer().print(msg);
                        UUID deviceid=this.asApiUuid(msg.getContext().getDeviceId());
                        System.out.println("topic-device:"+topic);
                        */
                        System.out.println("reformat开始:");
                        //context
                        context.put("deviceId", asApiUuid(msg.getContext().getDeviceId()));
                        context.put("deviceTypeId", asApiUuid(msg.getContext().getDeviceTypeId()));
                        context.put("deviceStatus", deviceStatus);
                        deviceStatus.put("value", msg.getContext().getDeviceStatus().getValue());
                        context.put("deviceMetadata", msg.getContext().getDeviceMetadataMap());
                        context.put("assignmentStatus", msg.getContext().getAssignmentStatus());
                        context.put("assignmentMetadata", msg.getContext().getAssignmentMetadataMap());
                        obj.put("context", context);
                        //event
                        measurement.put("name", msg.getEvent().getMeasurement().getName());
                        measurement.put("value", msg.getEvent().getMeasurement().getValue());
                        subevent.put("id", asApiUuid(msg.getEvent().getMeasurement().getEvent().getId()));
                        UUID deviceId = asApiUuid(msg.getEvent().getMeasurement().getEvent().getDeviceId());
                        subevent.put("deviceId", deviceId);
                        subevent.put("deviceAssignmentId", asApiUuid(msg.getEvent().getMeasurement().getEvent().getDeviceAssignmentId()));
                        subevent.put("customerId", asApiUuid(msg.getEvent().getMeasurement().getEvent().getCustomerId()));
                        subevent.put("areaId", asApiUuid(msg.getEvent().getMeasurement().getEvent().getAreaId()));
                        subevent.put("assetId", asApiUuid(msg.getEvent().getMeasurement().getEvent().getAssetId()));
                        subevent.put("eventDate", msg.getEvent().getMeasurement().getEvent().getEventDate());
                        subevent.put("receivedDate", msg.getEvent().getMeasurement().getEvent().getReceivedDate());
                        subevent.put("metadata", msg.getEvent().getMeasurement().getEvent().getMetadataMap());
                        measurement.put("event", subevent);
                        event.put("measurement", measurement);
                        obj.put("event", event);
                        System.out.println("费劲" + obj.toJSONString());

                        String topic = String.format("cep-new2-tenant-default-deviceId-%s", deviceId);
                        producer.send(new ProducerRecord<String, String>(topic, "Message", obj.toJSONString()));
                        System.out.println("分发结束");
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            producer.close();
        }
    }

    public static void main(String args[]) {
        ConsumerJsonObject consumer = new ConsumerJsonObject();
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
}
