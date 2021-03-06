package com.example.demo.pingshi.mqtt.sw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitewhere.rest.model.device.communication.DeviceRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.spi.SiteWhereException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author zhangyu
 * @description  MQTT 发布者
 * @date 2020-05-28 14:43
 */

public class MqttServerSWBJ {

    /**
     * 代理服务器ip地址
     */
    //public static final String MQTT_BROKER_HOST = "tcp://39.100.14.20:30703";
    public static final String MQTT_BROKER_HOST = "tcp://www.ca1078.cc:30703";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "SiteWhere/show/input/json";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "zasadarfr";


    /**
     * 客户端
     */
    public static MqttClient client;


    public static void main(String... args) {
        // 推送消息
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
            client.connect();

            MqttMessage message = new MqttMessage();
            message.setQos(1);
            message.setRetained(false);

            //调用各性化message
            MqttServerSWBJ instance=new MqttServerSWBJ();

            //选择event类型
            instance.sendNonStandardMeasurements(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * measurement
     *
     * @throws SiteWhereException
     */
    public void sendNonStandardMeasurements(MqttMessage message) throws SiteWhereException {
        while(true) {
            DeviceRequest request = new DeviceRequest();
            request.setDeviceToken("guan1");
            request.setType(DeviceRequest.Type.DeviceMeasurement);
            DeviceMeasurementCreateRequest mx = new DeviceMeasurementCreateRequest();
            mx.setName("normal");
            mx.setValue(10.23);
            mx.setEventDate(new Date());
            Map<String, String> metadata = new HashMap<String, String>();
            metadata.put("Device_Temperature", String.valueOf(Math.random()*100));
            metadata.put("Device_FX3U_Status", String.valueOf(Math.random()*10));
            metadata.put("Device_Foreward_Status", String.valueOf(Math.random()*100));
            metadata.put("Device_Pluse_Counts", String.valueOf(Math.random()*10000));
            Random r=new Random();
            metadata.put("Device_Reversal_Status",String.valueOf(r.nextInt(2)));
            mx.setMetadata(metadata);
            mx.setUpdateState(true);
            request.setRequest(mx);
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.convertValue(request, JsonNode.class);
                String payload = mapper.writeValueAsString(json);

                System.out.println("Payload:\n\n" + payload);
                client.publish(MQTT_TOPIC, payload.getBytes(), 1, false);
                System.out.println("Message sent successfully.");
                Thread.sleep(1000);
            } catch (JsonProcessingException e) {
                throw new SiteWhereException(e);
            } catch (Exception e) {
                throw new SiteWhereException(e);
            }
        }
    }

}
