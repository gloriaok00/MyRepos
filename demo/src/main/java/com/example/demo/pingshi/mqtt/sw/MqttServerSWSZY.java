package com.example.demo.pingshi.mqtt.sw;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitewhere.rest.model.device.communication.DeviceRequest;
import com.sitewhere.rest.model.device.event.request.DeviceLocationCreateRequest;
import com.sitewhere.rest.model.device.event.request.DeviceMeasurementCreateRequest;
import com.sitewhere.spi.SiteWhereException;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
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

public class MqttServerSWSZY {

    /**
     * 代理服务器ip地址
     */
    //public static final String MQTT_BROKER_HOST = "tcp://39.100.14.20:30003";
//  配置TCP
    public static final String MQTT_BROKER_HOST = "tcp://www.ca1078.cc:30703";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "SiteWhere/default/input/json";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "zasadar121d11212sr";


    /**
     * 客户端
     */
    public static MqttClient client;


    public static void main(String... args) throws MqttException {
        // 推送消息
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
            client.connect();

            MqttMessage message = new MqttMessage();
            message.setQos(1);
            message.setRetained(false);

            //调用各性化message
            MqttServerSWSZY instance=new MqttServerSWSZY();

            //选择event类型
            //instance.sendLocationOverMqtt(message);
            instance.sendNonStandardMeasurements(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void puremessageMqtt(MqttMessage message) throws Exception{
        Random r=new Random();
        while (true) {
            message.setPayload(String.valueOf(r.nextInt()).getBytes());
            client.publish(MQTT_TOPIC, message);
            System.out.println("已经发送");
            Thread.sleep(1000);
        }
    }

    /**
     * Location
     * @param message
     * @throws SiteWhereException
     */
    public void sendLocationOverMqtt(MqttMessage message) throws SiteWhereException {
        while(true){
            DeviceRequest request = new DeviceRequest();
            //request.setDeviceToken((Math.random()>0.5)?"40678-OPENHAB-324906":"70991-OPENHAB-8397183");
            //request.setDeviceToken((Math.random()>0.5)?"41520-LAIPAC-S911-4159787":"94176-LAIPAC-S911-2308706");
            request.setType(DeviceRequest.Type.DeviceLocation);
            DeviceLocationCreateRequest location = new DeviceLocationCreateRequest();
            location.setEventDate(new Date());
            location.setLatitude(Math.random());
            location.setLongitude(Math.random());
            location.setElevation(Math.random());
            Map<String, String> metadata = new HashMap<String, String>();
            metadata.put("fromMQTT", "true");
            location.setMetadata(metadata);
            location.setUpdateState(true);
            request.setRequest(location);
            try {
                String payload = MarshalUtils.PRETTY_MAPPER.writeValueAsString(request);
                message.setPayload(payload.getBytes());
                client.publish("SiteWhere/default/input/json",message);
                System.out.println("已发送Request:");
                System.out.println(JSONObject.toJSON(request));
                Thread.sleep(1000);
            } catch (JsonProcessingException e) {
                throw new SiteWhereException(e);
            } catch (Exception e) {
                throw new SiteWhereException(e);
            }
        }
    }

    /**
     * measurement
     *
     * @throws SiteWhereException
     */
    public void sendNonStandardMeasurements(MqttMessage message) throws SiteWhereException {
        while(true){
            DeviceRequest request = new DeviceRequest();
            //String DeviceToken1="41520-LAIPAC-S911-4159787";
            //String DeviceToken2="94176-LAIPAC-S911-2308706";
            //request.setDeviceToken((Math.random()>0.5)?DeviceToken1:DeviceToken2);
//       设备ID
            request.setDeviceToken("16445-GATEWAY-8223142");
            request.setType(DeviceRequest.Type.DeviceMeasurement);
            request.setOriginator("device");
            DeviceMeasurementCreateRequest mx = new DeviceMeasurementCreateRequest();
            mx.setName("normal");
            mx.setValue(Math.random());
            mx.setEventDate(new Date());
            Map<String, String> metadata = new HashMap<String, String>();
            //模拟数据时，deviceA只放A集合参数，deviceB放B集合参数

            metadata.put("Device_FX3U_Status",(Math.random()>0.5)?"0":"1");
            metadata.put("Device_Pressure",String.format("%.2f", Math.random()*100));
            metadata.put("Device_Flow",String.format("%.2f", Math.random()));

            //metadata.put("from","mqtt");
            mx.setMetadata(metadata);
            mx.setUpdateState(true);
            request.setRequest(mx);
            try {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.convertValue(request, JsonNode.class);
                String payload = mapper.writeValueAsString(json);
                System.out.println("Payload:\n\n" + payload);
                message.setPayload(payload.getBytes());
                client.publish("SiteWhere/default/input/json",message);
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
