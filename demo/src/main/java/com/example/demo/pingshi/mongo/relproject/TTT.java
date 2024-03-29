package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.util.ArrayList;
import java.util.List;
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
        List<Document> list = iotdb.getCollection("task").find().into(new ArrayList<>());
        list.forEach(e -> {
            //System.out.println(e.get("_id").toString());
            Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(e.get("_id").toString()), UuidRepresentation.JAVA_LEGACY));

            Document query = new Document();
            query.put("_id", bb);


            Document one = iotdb.getCollection("task").find(query).first();
            Double bt = Double.parseDouble(one.getString("batchType"));

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
        });

    }
}
