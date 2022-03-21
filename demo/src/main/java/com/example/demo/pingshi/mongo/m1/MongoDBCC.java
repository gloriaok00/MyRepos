package com.example.demo.pingshi.mongo.m1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @description
 * @date 2022-03-21 14:43
 */

public class MongoDBCC {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("223.223.176.32", 30708);
        MongoDatabase db=mongoClient.getDatabase("tenant-zy_t16");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        db.createCollection("assignments");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Document doc=new Document();
        doc.put("_id","1023");
        db.getCollection("assignments").insertOne(doc);
    }
}
