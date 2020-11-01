package com.example.demo.pingshi.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhangyu
 * @description MQTT 接收者
 * @date 2020-05-28 14:43
 */

public class MyMqttClient {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://broker.emqx.io:1883";

    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "saxswef";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "t2";

    private volatile static MqttClient mqttClient;

    public static void main(String... args) throws MqttException {
        try {
            mqttClient = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
            // 连接
            mqttClient.connect();
            // 订阅
            mqttClient.subscribe(MQTT_TOPIC);
            // 设置回调
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable throwable) {
                    System.out.println("connectionLost");
                }

                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                    System.out.println("Topic: " + s + " 收到Message: " + mqttMessage.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}