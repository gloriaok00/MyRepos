package com.example.demo.pingshi.mongo.m9;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description 随机练习 时间相加就用运算符$add
 * @date 2022/11/23 16:11
 */

public class M9 {

    @Test
    @SneakyThrows
    public void xxx() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase iotdb = mongoClient.getDatabase("Foo").withCodecRegistry(pojoCodecRegistry);
        Document project = new Document();
        Document xx = new Document();
        List<Object> l1 = new ArrayList<>();
        l1.add("$pdate");
        l1.add(1000);
        xx.put("$add", l1);
        project.put("dd", xx);

        Document doc = iotdb.getCollection("f2").aggregate(Arrays.asList(Aggregates.project(project))).first();
        System.out.println(doc.getDate("dd").toString());
    }
}
