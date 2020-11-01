package com.example.demo.pingshi.kafka.sw;

import com.sitewhere.grpc.model.CommonModel.GDeviceAssignmentStatus;
import com.sitewhere.grpc.model.CommonModel.GOptionalString;
import com.sitewhere.grpc.model.CommonModel.GUUID;
import com.sitewhere.grpc.model.DeviceEventModel.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public  class MeasurementDataMock {
    /**
     * 随机生成UUID
     * @return
     */
    private GUUID generateMockGuuid() {
        GUUID.Builder guuid = GUUID.newBuilder();

        UUID uuid = UUID.randomUUID();
        guuid.setLsb(uuid.getLeastSignificantBits());
        guuid.setMsb(uuid.getMostSignificantBits());

        return guuid.build();
    }

    private GAnyDeviceEvent createGAnyDeviceEvent() {
        GAnyDeviceEvent.Builder grpc = GAnyDeviceEvent.newBuilder();
        grpc.setMeasurement(createDeviceMeasurement()) ;
        return grpc.build() ;
    }

    private GDeviceMeasurement createDeviceMeasurement() {
        GDeviceMeasurement.Builder grpc = GDeviceMeasurement.newBuilder();
        grpc.setName("zy");
        grpc.setValue(10.23);
        grpc.setEvent(createMockGDeviceEvent());
        return grpc.build();
    }

    private GDeviceEventContext createMockGDeviceEventContext() {
        GDeviceEventContext.Builder grpc = GDeviceEventContext.newBuilder();
        grpc.setDeviceId(generateMockGuuid());
        grpc.setDeviceTypeId(generateMockGuuid());
        grpc.setDeviceStatus(GOptionalString.newBuilder().setValue("On"));

        Map<String, String> allDeviceMetaData = new HashMap<String, String>() ;
        allDeviceMetaData.put("meta1", "val1") ;
        allDeviceMetaData.put("meta2", "val2") ;
        grpc.putAllDeviceMetadata(allDeviceMetaData);
        grpc.setAssignmentStatus(GDeviceAssignmentStatus.ASSN_STATUS_ACTIVE) ;

        Map<String, String> allAssignmentMetaData = new HashMap<String, String>() ;
        allAssignmentMetaData.put("ass1", "valass1") ;
        allAssignmentMetaData.put("ass2", "valass2") ;
        allAssignmentMetaData.put("ass3", "valass3") ;
        grpc.putAllAssignmentMetadata(allAssignmentMetaData);
        return grpc.build();
    }

    private GDeviceEvent createMockGDeviceEvent() {
        GDeviceEvent.Builder grpc = GDeviceEvent.newBuilder();
        grpc.setId(generateMockGuuid());
        grpc.setEventType(GDeviceEventType.EVENT_TYPE_MEASUREMENT);
        grpc.setDeviceId(generateMockGuuid());
        grpc.setDeviceAssignmentId(generateMockGuuid());
        grpc.setCustomerId(generateMockGuuid());
        grpc.setAreaId(generateMockGuuid());
        grpc.setAssetId(generateMockGuuid());
        grpc.setEventDate(System.currentTimeMillis());
        grpc.setReceivedDate(System.currentTimeMillis());
        Map<String, String> allEventMetaData = new HashMap<String, String>() ;
        Random random = new Random(100);
        allEventMetaData.put("Device_Temperature", Float.toString(random.nextFloat()));
        allEventMetaData.put("Device_Flow", Float.toString(random.nextFloat()));
        allEventMetaData.put("Device_Pressure", Float.toString(random.nextFloat()));
        grpc.putAllMetadata(allEventMetaData);
        return grpc.build();
    }

    public GEnrichedEventPayload createMockGEnrichedEventPayload(){
        GEnrichedEventPayload.Builder grpc = GEnrichedEventPayload.newBuilder();
        grpc.setContext(createMockGDeviceEventContext()) ;
        grpc.setEvent(createGAnyDeviceEvent()) ;
        return grpc.build() ;
    }
}