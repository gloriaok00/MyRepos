package com.example.demo.pingshi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhangyu
 * @description
 * @date 2021-08-12 14:52
 */

public class SiddhiZH {
    public static void main(String[] args) throws JSONException {
        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
        MongoCollection<Document> myCollect = mongoDatabase.getCollection("test1");
        Document show=new Document();
        show.put("name",1);
        show.put("parameters",1);
        AggregateIterable<Document> result =myCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "source")),
                        Aggregates.project(show)
                )
        );
        System.out.println(result.into(new ArrayList<>()).size());
        ArrayList<Document> dfsdf=result.into(new ArrayList<>());
        JSONObject obj=new JSONObject();
        obj.put("sources",dfsdf);
        System.out.println("df");
    }

}
