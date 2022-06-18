package com.example.demo.pingshi.mqtt.m1;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @description mqtt retain随机练习
 * @date 2022/6/18 17:14
 */

public class MqttPublisher {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://broker.emqx.io:1883";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "home/2F/201/temperature";

    /**
     * 客户端
     */
    public static MqttClient client;


    public static void main(String... args) throws MqttException {
        // 推送消息
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MqttClient.generateClientId());
            client.connect();

            MqttMessage message = new MqttMessage();
            message.setQos(0);
            //Retain为broker的设置,只保留最后一条信息
            message.setRetained(true);
            JSONObject obj = new JSONObject();
            for (int i = 0; i < 100; i++) {
                obj.put("id", i);
                message.setPayload(JSONObject.toJSONString(obj).getBytes());
                client.publish(MQTT_TOPIC, message);
                System.out.println("msg sent successfully..");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
