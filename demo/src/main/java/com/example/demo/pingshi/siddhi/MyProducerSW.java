package com.example.demo.pingshi.siddhi;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author zhangyu
 * @description
 * @date 2020-07-10 13:05
 */

public class MyProducerSW {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int i = 1; i <= 10; i++) {
            //EnrichedEventPayload temp = initPayload(i);
            //producer.send(new ProducerRecord<String, String>("t3", "Message" + i, JSONObject.toJSONString(temp)));
        }
        producer.close();
    }

   /* public static EnrichedEventPayload initPayload(int i) {
        EnrichedEventPayload instance = new EnrichedEventPayload();
        DeviceEventContext eventContext = new DeviceEventContext();
        UUID deviceId = UUID.randomUUID();
        eventContext.setDeviceId(deviceId);
        eventContext.setAssignmentStatus(DeviceAssignmentStatus.Active);
        eventContext.setDeviceTypeId(UUID.randomUUID());
        instance.setEventContext(eventContext);
        DeviceMeasurement deviceMeasurement = new DeviceMeasurement();
        deviceMeasurement.setName(i + "号设备");
        deviceMeasurement.setValue(Math.random());
        HashMap metaMap = new HashMap();
        metaMap.put("deviceFX3UStatus", Math.random() > 0.5 ? 1 : 0);
        metaMap.put("devicePluseCounts", 123);
        metaMap.put("deviceForewardStatus", 223);
        metaMap.put("deviceReversalStatus", 323);
        metaMap.put("deviceTemperature", new BigDecimal(Math.random() * 100).setScale(1, BigDecimal.ROUND_HALF_UP));
        deviceMeasurement.setMetadata(metaMap);
        deviceMeasurement.setId(UUID.randomUUID());
        deviceMeasurement.setDeviceId(deviceId);
        deviceMeasurement.setDeviceAssignmentId(UUID.randomUUID());
        deviceMeasurement.setCustomerId(UUID.randomUUID());
        deviceMeasurement.setAreaId(UUID.randomUUID());
        deviceMeasurement.setAssetId(UUID.randomUUID());
        deviceMeasurement.setEventDate(new Date());
        deviceMeasurement.setReceivedDate(new Date());
        instance.setEvent(deviceMeasurement);
        return instance;
    }*/
}
