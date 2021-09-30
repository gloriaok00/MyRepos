package com.example.demo.pingshi.mqtt;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Random;

/**
 * @author zhangyu
 * @description MQTT 发布者
 * @date 2021-05-07 10:17
 */

public class MqttPoint {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://127.0.0.1:1883";
    //public static final String MQTT_BROKER_HOST = "ws://223.223.176.32:30714";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "t1";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "fdsfdfdsf";


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
            /*

            {
"data": [
{
"x": 281,
"y": 500
},
{
"x": 281
"y": 789
}
]
}
             */
            for (int i = 1; i < 100000000; i++) {
                JSONArray data = new JSONArray();
                JSONObject d1 = new JSONObject();
                d1.put("x", i);
                d1.put("y", new Random().nextInt(100) + 1);
                data.add(d1);
                JSONObject d2 = new JSONObject();
                d2.put("x", i);
                d2.put("y", new Random().nextInt(1000) + 101);
                data.add(d2);
                obj.put("data", data);
                System.out.println("xx:" + obj.toJSONString());
                message.setPayload(JSONObject.toJSONString(obj).getBytes());
                client.publish(MQTT_TOPIC, message);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
