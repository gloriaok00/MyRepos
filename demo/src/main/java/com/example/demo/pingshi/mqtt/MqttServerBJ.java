package com.example.demo.pingshi.mqtt;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhangyu
 * @description MQTT 发布者
 * @date 2021-05-07 10:39
 */

public class MqttServerBJ {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://www.ca1078.cc:30703";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "t2";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "waaaqk09k09wew";


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
            JSONObject obj = new JSONObject();
            Thread.sleep(1000);
            for (int i = 0; i < 10000; i++) {
                obj.put("id", i);
                message.setPayload(JSONObject.toJSONString(obj).getBytes());
                client.publish(MQTT_TOPIC, message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
