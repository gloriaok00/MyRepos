package com.example.demo.pingshi.kafka.sw.pojo;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @author zhangyu
 * @description  POJO Outbound json 子消息数据
 * @date 2020-08-28 21:10
 */

public class DemoPOJO {
    public static void main(String[] args) {
        Context context=new Context();
        context.setAssignmentStatus("ASSN_STATUS_ACTIVE");
      /*  context.setDeviceId(UUID.randomUUID().getMostSignificantBits());
        context.setDeviceTypeId(UUID.randomUUID().toString());*/
        HashMap<String,String> map1=new HashMap<>();
        map1.put("ass2","valass2");
        map1.put("ass1","valass1");
        map1.put("ass3","valass3");
        context.setAssignmentMetadata(map1);
        HashMap<String,String> map2=new HashMap<>();
        map2.put("meta2","val2");
        map2.put("meta1","val1");
        context.setDeviceMetadata(map2);
        DeviceStatus deviceStatus=new DeviceStatus();
        deviceStatus.setValue("On");
        context.setDeviceStatus(deviceStatus);

        Event event=new Event();
        Measurement measurement=new Measurement();
        measurement.setName("zy");
        measurement.setValue(10.23);
        SubEvent subEvent=new SubEvent();
      /*  subEvent.setAreaId(UUID.randomUUID().toString());
        subEvent.setAssetId(UUID.randomUUID().toString());
        subEvent.setCustomerId(UUID.randomUUID().toString());
        subEvent.setId(UUID.randomUUID().toString());
        subEvent.setDeviceAssignmentId(UUID.randomUUID().toString());
        subEvent.setDeviceId(UUID.randomUUID().toString());*/
      /*  subEvent.setReceivedDate("1111");
        subEvent.setEventDate("2222");*/
       /* HashMap<String,String> map3=new HashMap<>();
        map3.put("device_flow","1023.11");
        map3.put("device_pressure","131");
        subEvent.setMetadata(map3);*/
        measurement.setEvent(subEvent);
        event.setMeasurement(measurement);

        EventMessage eventMessage=new EventMessage();
        eventMessage.setContext(context);
        eventMessage.setEvent(event);

        System.out.println(JSONObject.toJSON(eventMessage));
    }
}
