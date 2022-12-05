package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 *  @description 为壁厚数据增加sn
 *  @date  2022/12/5 18:21
 */

public class DDD {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document d1 = new Document();
        d1.put("code", 3);

        List<Document> list = iotdb.getCollection("thick").find(d1).into(new ArrayList<>());
        list.forEach(e -> {
            Document query = new Document();
            query.put("_id", e.getObjectId("_id"));
            String[] nn = e.getString("name").split("内环");
            System.out.println(nn[1]);
            Document set = new Document();
            set.put("sn", new Double(nn[1]));
            Document xx = new Document();
            xx.put("$set", set);
            iotdb.getCollection("thick").updateOne(query, xx);
        });

    }
}
