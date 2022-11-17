package com.example.demo.pingshi.mongo.m6;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.Arrays;

/**
 * @description
 * @date 2022/11/16 21:14
 */

public class M6 {

    @SneakyThrows
    public static void main(String[] args) {
        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        MongoCollection<Document> col = iotdb.getCollection("f1");
        //db.getCollection('f1').aggregate([{$project:{cc:{$dateToString:{format:"%Y-%m-%d %H:%M:%S", date:"$xx"}}}}])
        Document e = col.aggregate(Arrays.asList(Aggregates.project(Document.parse("{cc:{$dateToString:{format:\"%Y-%m-%d %H:%M:%S\", date:\"$xx\"}}}")))).first();
        System.out.println(e.toJson());
        Gson g = new Gson();
        MDTO base = g.fromJson(e.toJson(), MDTO.class);
        System.out.println(base.getCc());
    }
}
