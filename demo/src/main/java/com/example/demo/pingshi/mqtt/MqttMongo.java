package com.example.demo.pingshi.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhangyu
 * @description MQTT 发布者
 * @date 2021-05-07 10:17
 */

public class MqttMongo {

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
    public static final String MQTT_CLIENT_ID = "fdsfdfddfdsfsf";


    /**
     * 客户端
     */
    private volatile static MqttClient mqttClient;

    public static void main(String... args) throws MqttException {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
            MongoCollection<Document> myCollect = mongoDatabase.getCollection("F4");
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
                    JSONObject obj = JSON.parseObject(mqttMessage.toString());
                    obj.put("createdTime", System.currentTimeMillis());
                    System.out.println(obj.toJSONString());
                    Document doc = Document.parse(obj.toJSONString());
                    myCollect.insertOne(doc);
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
