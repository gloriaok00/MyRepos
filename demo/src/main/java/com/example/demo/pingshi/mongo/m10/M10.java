package com.example.demo.pingshi.mongo.m10;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2022/11/18 14:28
 */

@Slf4j
public class M10 {

    @Test
    @SneakyThrows
    public void xxx() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoDatabase iotdb = mongoClient.getDatabase("Foo").withCodecRegistry(pojoCodecRegistry);

        //find写法
        List<M10DTO> d1 = iotdb.getCollection("f2").find(M10DTO.class).into(new ArrayList<>());
        log.info(d1.toString());
        //aggregate写法
        Document match = new Document();
        match.put("name", "xxx");
        List<M10DTO> d2 = iotdb.getCollection("f2").aggregate(Arrays.asList(Aggregates.match(match)), M10DTO.class).into(new ArrayList<>());
        log.info(d2.toString());

    }

}
