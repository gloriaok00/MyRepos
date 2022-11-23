package com.example.demo.pingshi.mongo.m8;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.util.UUID;

/**
 * @description 修改task batchType
 * @date 2022/11/23 09:29
 */

public class TTT {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString("a2999e3f-5cc9-4b15-b5cc-20b237c875e9"), UuidRepresentation.JAVA_LEGACY));

        Document query = new Document();
        query.put("_id", bb);


        Document one = iotdb.getCollection("task").find(query).first();
        Double bt=Double.parseDouble(one.getString("batchType"));

        System.out.println("getting one:" + bt);

        Document mm = new Document();
        mm.put("batchType", 1);
        Document doc = new Document();
        doc.put("$unset", mm);
        iotdb.getCollection("task").updateOne(query, doc);
        Document mmNew = new Document();
        mmNew.put("batchType", bt);
        Document docNew = new Document();
        docNew.put("$set", mmNew);
        iotdb.getCollection("task").updateOne(query, docNew);

    }
}
