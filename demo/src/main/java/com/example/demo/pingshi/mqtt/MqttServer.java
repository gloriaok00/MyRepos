package com.example.demo.pingshi.mqtt;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.HashMap;

/**
 * @author zhangyu
 * @description  MQTT 发布者
 * @date 2020-05-28 14:43
 */

public class MqttServer {

    /**
     * 代理服务器ip地址
     */
    public static final String MQTT_BROKER_HOST = "tcp://broker.emqx.io:1883";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "t1";


    /**
     * 客户端唯一标识
     */
    public static final String MQTT_CLIENT_ID = "wewqcew";


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
            while(true){
                JSONObject jsonObj=new JSONObject();
                jsonObj.put("name","zy");
                jsonObj.put("amount",Math.random());
                JSONObject jsonObjSub=new JSONObject();
                jsonObjSub.put("age",Math.random());
                HashMap<String,String> m1=new HashMap<>();
                m1.put("m1","m1");
                m1.put("m11","m11");
                jsonObjSub.put("metadata",m1);
                jsonObj.put("req",jsonObjSub);
                message.setPayload(JSONObject.toJSONBytes(jsonObj));
                //message.setPayload(String.valueOf(Math.random()).getBytes());
                System.out.println("已经发送:");
                System.out.println(jsonObj);
                client.publish(MQTT_TOPIC, message);
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
