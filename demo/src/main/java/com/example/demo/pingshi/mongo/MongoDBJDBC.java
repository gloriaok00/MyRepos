package com.example.demo.pingshi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBJDBC {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
            MongoCollection<Document> myCol = mongoDatabase.getCollection("FooTable1");

                /*Document temp = new Document("id", 100000);
                myCol.insertOne(temp);*/
            /* */
            for (int i = 100001; i < 1000000; i++) {
                Document temp = new Document("id", i);
                myCol.insertOne(temp);
                //Thread.sleep(100);
            }

            //System.out.println(myCol.toString());
            //System.out.println("Connect to database successfully");

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
