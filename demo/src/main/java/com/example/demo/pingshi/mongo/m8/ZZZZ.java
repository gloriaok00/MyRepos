package com.example.demo.pingshi.mongo.m8;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2022/10/19 11:16
 */

public class ZZZZ {

    public static void main(String[] args) {
        String uri = "mongodb://127.0.0.1:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoDatabase database = mongoClient.getDatabase("iot").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Document> collection = database.getCollection("params");
            try {
                List<ProcessParam> list = new ArrayList<>();
                list.add(new ProcessParam("精炼温度", 89.41, 89.78, 90.34, 88.45, 0.1));
                list.add(new ProcessParam("精炼时间", 89.56, 89.99, 91.22, 89.05, 0.1));
                list.add(new ProcessParam("真空度", 10.56, 10.99, 10.22, 10.05, 0.1));
                list.add(new ProcessParam("浇注温度", 11.56, 11.99, 11.22, 11.05, 0.1));
                list.add(new ProcessParam("浇注速度", 12.56, 12.99, 12.22, 12.05, 0.1));
                list.add(new ProcessParam("抽真空时间", 13.56, 13.99, 13.22, 13.05, 0.1));
                list.add(new ProcessParam("破真空时间", 14.56, 14.99, 13.22, 14.05, 0.1));
                list.add(new ProcessParam("合金温度", 15.56, 15.99, 15.22, 15.05, 0.1));
             /*   list.add(new ProcessParam("背层间温湿度", 16.56, 16.99, 16.22, 16.05, 0.1));
                list.add(new ProcessParam("淋砂机含砂量", 16.56, 16.99, 16.22, 16.05, 0.1));
                list.add(new ProcessParam("残余强度", 16.56, 16.99, 16.22, 16.05, 0.1));
                list.add(new ProcessParam("室温强度", 16.56, 16.99, 16.22, 16.05, 0.1));*/
                Document doc = new Document("processNumber", 50).append("params", list);
                collection.insertOne(doc);
            } catch (MongoException me) {
                System.err.println("Unable to insert due to an error: " + me);
            }
        }
    }
}
