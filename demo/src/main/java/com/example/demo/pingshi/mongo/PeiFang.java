package com.example.demo.pingshi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author zhangyu
 * @description
 * @date 2021-09-22 17:42
 */

public class PeiFang {

    public static MqttClient client;
    public static final String MQTT_BROKER_HOST = "tcp://127.0.0.1:1883";
    public static final String MQTT_TOPIC = "t2";
    public static final String MQTT_CLIENT_ID = "dfmiji";


    public static void main(String[] args) throws Exception {
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
        MongoCollection<Document> myCollect = mongoDatabase.getCollection("peifang");
        Document doc = myCollect.find().projection(Projections.excludeId()).first();
        doc.put("type", 1);

        client = new MqttClient(MQTT_BROKER_HOST, MQTT_CLIENT_ID, new MemoryPersistence());
        client.connect();

        MqttMessage message = new MqttMessage();
        message.setQos(1);
        message.setRetained(false);

        message.setPayload(doc.toJson().getBytes());
        client.publish(MQTT_TOPIC, message);

    }
}
