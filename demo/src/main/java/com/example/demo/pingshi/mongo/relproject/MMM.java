package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 为支板宽度A和支板圆心距S增加sn
 * @date 2022/12/2 17:05
 */

public class MMM {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document d1 = new Document();
        d1.put("code", 2);

        List<Document> list = iotdb.getCollection("cmm").find(d1).into(new ArrayList<>());
        list.forEach(e -> {
            Document query = new Document();
            query.put("_id", e.getObjectId("_id"));
            String[] nn = e.getString("name").split("支板圆心距S");
            System.out.println(nn[0]);
            Document set = new Document();
            set.put("sn", new Double(nn[0]));
            Document xx = new Document();
            xx.put("$set", set);
            iotdb.getCollection("cmm").updateOne(query, xx);
        });

    }
}
