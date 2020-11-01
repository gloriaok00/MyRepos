package com.example.demo.pingshi.kafka.sw;

import com.alibaba.fastjson.JSONObject;
import com.sitewhere.grpc.model.CommonModel;
import com.sitewhere.grpc.model.DeviceEventModel;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

/**
 * @author zhangyu
 * @description 模拟生产kafka sw enrichedEvent payload 往自己的topic里
 * @date 2020-08-23 12:23
 */

public class Producer {

    //消息打印输出实体
    private static JSONObject obj=new JSONObject();
    //context
    private static JSONObject context=new JSONObject();
    private static JSONObject deviceStatus=new JSONObject();
    //event
    private static JSONObject event=new JSONObject();
    private static JSONObject measurement=new JSONObject();
    private static JSONObject subevent=new JSONObject();

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", com.example.demo.pingshi.kafka.sw.GEnrichedEventPayloadSerializer.class);
        KafkaProducer<String, DeviceEventModel.GEnrichedEventPayload> producer = new KafkaProducer<String, DeviceEventModel.GEnrichedEventPayload>(props);
        try {
            for (int i=0;i<300;i++ ) {
                MeasurementDataMock measurementDataMock = new MeasurementDataMock();
                DeviceEventModel.GEnrichedEventPayload msg = null;
                msg = measurementDataMock.createMockGEnrichedEventPayload();
                //sitewhere.sitewhere.tenant.t2.outbound-events
                producer.send(new ProducerRecord<String, DeviceEventModel.GEnrichedEventPayload>("t1", "Message", msg));
                CommonModel.GUUID guuid = msg.getContext().getDeviceId();
                UUID deviceId = new UUID(guuid.getMsb(), guuid.getLsb());
                System.out.println("已发送.." + deviceId);
                //消息打印
                printSentMessage(msg);
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            producer.close();
        }
    }

    private static void printSentMessage(DeviceEventModel.GEnrichedEventPayload msg){
        //context
        context.put("deviceId",asApiUuid(msg.getContext().getDeviceId()));
        context.put("deviceTypeId",asApiUuid(msg.getContext().getDeviceTypeId()));
        context.put("deviceStatus",deviceStatus);
        deviceStatus.put("value",msg.getContext().getDeviceStatus().getValue());
        context.put("deviceMetadata",msg.getContext().getDeviceMetadataMap());
        context.put("assignmentStatus",msg.getContext().getAssignmentStatus());
        context.put("assignmentMetadata",msg.getContext().getAssignmentMetadataMap());
        obj.put("context",context);
        //event
        measurement.put("name",msg.getEvent().getMeasurement().getName());
        measurement.put("value",msg.getEvent().getMeasurement().getValue());
        subevent.put("id",asApiUuid(msg.getEvent().getMeasurement().getEvent().getId()));
        UUID deviceId=asApiUuid(msg.getEvent().getMeasurement().getEvent().getDeviceId());
        subevent.put("deviceId",deviceId);
        subevent.put("deviceAssignmentId",asApiUuid(msg.getEvent().getMeasurement().getEvent().getDeviceAssignmentId()));
        subevent.put("customerId",asApiUuid(msg.getEvent().getMeasurement().getEvent().getCustomerId()));
        subevent.put("areaId",asApiUuid(msg.getEvent().getMeasurement().getEvent().getAreaId()));
        subevent.put("assetId",asApiUuid(msg.getEvent().getMeasurement().getEvent().getAssetId()));
        subevent.put("eventDate",msg.getEvent().getMeasurement().getEvent().getEventDate());
        subevent.put("receivedDate",msg.getEvent().getMeasurement().getEvent().getReceivedDate());
        subevent.put("metadata",msg.getEvent().getMeasurement().getEvent().getMetadataMap());
        measurement.put("event",subevent);
        event.put("measurement",measurement);
        obj.put("event",event);
        System.out.println("已发送消息:");
        System.out.println(obj.toJSONString());
    }

    public static UUID asApiUuid(CommonModel.GUUID grpc){
        if (grpc == null) {
            return null;
        }
        return new UUID(grpc.getMsb(), grpc.getLsb());
    }
}
