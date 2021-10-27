package com.example.demo.pingshi.datatype;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author zhangyu
 * @description  字符串类型
 * @date 2020-10-13 16:13
 */

public class StringDemo {

    public static void main(String[] args) throws Exception{
    }

    @Test
    public void stringIO() throws Exception{
        OutputStream out=new FileOutputStream("./src/main/resources/aa.txt");
        String sourceText="@App:name(%s)\n" +
                "@App:description(%s)\n"+
                "@source(type = \"kafka111\", topic.list = \"%s\", partition.no.list = \"0\", threading.option = \"single.thread\", group.id = \"iot-cep-group\", bootstrap.servers = \"39.100.14.20:30712\", @map(type = \"json\", @attributes(assignmentStatus = \"context.assignmentStatus\", deviceTypeId = \"context.deviceTypeId\", deviceIdEvent = \"event.measurement.event.deviceId\", metadata = \"event.measurement.event.metadata\", deviceId = \"context.deviceId\", areaId = \"event.measurement.event.areaId\", assetId = \"event.measurement.event.assetId\", name = \"event.measurement.name\", id = \"event.measurement.event.id\", deviceAssignmentId = \"event.measurement.event.deviceAssignmentId\", receivedDate = \"event.measurement.event.receivedDate\", value = \"event.measurement.value\", eventDate = \"event.measurement.event.eventDate\")))\n" +
                "define stream SweetProductionAlertStream (deviceTypeId string, assignmentStatus string, deviceId string, areaId string, assetId string, id string, deviceAssignmentId string, deviceIdEvent string, receivedDate string, eventDate string, metadata object, value double, name string);";
        out.write(sourceText.getBytes());
    }

    @Test
    public void stringsplit(){
        String SSS="a1.siddhi";
        //对于正常的截串都没问题，但是由于有特殊符号，需要转义才能生效
        String[] aaaaa=SSS.split("\\.");
        System.out.println(aaaaa[1]);
    }
}
