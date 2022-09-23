package com.example.demo.pingshi.mqtt.sw;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author zhangyu
 * @description MQTT 发布者
 * @date 2020-05-28 14:43
 */

public class MqttServerSWBJ {

    /**
     * 代理服务器ip地址
     */
    //public static final String MQTT_BROKER_HOST = "tcp://39.100.14.20:30703";
    public static final String MQTT_BROKER_HOST = "tcp://223.223.176.32:30703";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "SuperLink/default/input/json";


    /**
     * 客户端
     */
    public static MqttClient client;


    public static void main(String... args) {
        // 推送消息
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MqttClient.generateClientId());
            client.connect();

            MqttMessage message = new MqttMessage();
            message.setQos(1);
            message.setRetained(false);

            //调用各性化message
            MqttServerSWBJ instance = new MqttServerSWBJ();

            //选择event类型
            //instance.sendNonStandardMeasurements(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * measurement
     *
     * @throws SiteWhereException
     */
     /*
    public void sendNonStandardMeasurements(MqttMessage message) throws SiteWhereException {
        while (true) {
            DeviceRequest request = new DeviceRequest();
            request.setDeviceToken("81625-IPHONE6S-7081704");
            request.setType(DeviceRequest.Type.DeviceMeasurement);
            DeviceMeasurementCreateRequest mx = new DeviceMeasurementCreateRequest();
            mx.setName("normal");
            mx.setValue(100);
            mx.setEventDate(new Date());
            Map<String, String> metadata = new HashMap<String, String>();
            metadata.put("t10", String.valueOf(Math.random() * 100));
            metadata.put("t11", String.valueOf(Math.random() * 10));
            metadata.put("t12", String.valueOf(Math.random() * 100));
            metadata.put("t1", String.valueOf(Math.random() * 10000));
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
*/
}
