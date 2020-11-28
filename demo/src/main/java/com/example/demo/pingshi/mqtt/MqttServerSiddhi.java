package com.example.demo.pingshi.mqtt;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhangyu
 * @description  MQTT 发布者
 * @date 2020-05-28 14:43
 */

public class MqttServerSiddhi {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://127.0.0.1:1883";

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
            JSONObject obj=new JSONObject();
            Thread.sleep(1000);
            while(true) {
                obj.put("name","1");
                obj.put("amount",13.2);
                message.setPayload(JSONObject.toJSONString(obj).getBytes());
                client.publish(MQTT_TOPIC, message);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
