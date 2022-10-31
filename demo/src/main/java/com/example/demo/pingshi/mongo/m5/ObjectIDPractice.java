package com.example.demo.pingshi.mongo.m5;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;

/**
 * @description 正常的objectId是可以这样取的
 * @date 2022/11/1 01:20
 */

public class ObjectIDPractice {

    @SneakyThrows
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        MongoCollection<Document> col = iotdb.getCollection("f1");
        FindIterable<Document> mm = col.find();
        MongoCursor<Document> nn = mm.iterator();
        while (nn.hasNext()) {
            Document d = nn.next();
            System.out.println(d.getObjectId("_id").toString());
        }

    }
}
