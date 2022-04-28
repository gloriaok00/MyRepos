package com.example.demo.pingshi.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Random;

/**
 * @description MQTT 发送
 * @date 2022-04-28 21:04
 */

public class MqttOwn {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://localhost:1883";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "/zy/test";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "xczxcdwdq";


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
            message.setQos(0);
            message.setRetained(false);

            //调用各性化message
            MqttOwn instance = new MqttOwn();

            //选择event类型
            instance.pureMessageMqtt(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pureMessageMqtt(MqttMessage message) throws Exception {
        Random r = new Random();
        int l= 10;
        for (int i = 0; i < l; i++) {
            message.setPayload(String.valueOf(r.nextInt()).getBytes());
            client.publish(MQTT_TOPIC, message);
            System.out.println("已经发送:"+message);
        }
    }
}
