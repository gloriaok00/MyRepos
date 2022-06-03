package com.example.demo.pingshi.mongo.m2;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @description  本质是mongo的java api不熟 临时保存 以后慢慢熟悉
 * @date 2022-05-09 10:03
 * @date 2022-06-03 23:28
 */

public class M2Demo {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("223.223.176.32", 30708);
        MongoDatabase db = mongoClient.getDatabase("tenant-default");
        MongoCollection<Document> cols = db.getCollection("assignments");

        ArrayList<Document> xxx = cols.find()
                .projection(Projections.include("_id"))
                .into(new ArrayList<>());
        List<UUID> a1 = new ArrayList<>();
        UUID u1 = UUID.fromString("7f8752ca-271a-4ca6-be09-16b9eeefb603");
        a1.add(u1);
        UUID u2 = UUID.fromString("18c624f0-b9b8-4f50-814d-deb356e5bc6b");
        a1.add(u2);
        Document nn = new Document();
        nn.put("$in", a1);
        Document doc = new Document();
        doc.put("_id", nn);
        ArrayList<Document> bb = cols.find(doc).projection(Projections.include("tokn")).into(new ArrayList<>());
        bb.forEach(e -> System.out.println(e.toJson()));
        Map<String,String> zz=bb.stream().collect(Collectors.toMap(e->e.get("_id").toString(), e->e.get("tokn").toString()));
        System.out.println(zz.size());
    }
}
