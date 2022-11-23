package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description 录工序数据fix
 * @date 2022/11/22 16:04
 */

public class KKK {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document query = new Document();
        query.put("taskNumber", "22-10-6");
       /* Document pp = new Document();
        pp.put("$ne", 5);
        query.put("processNumber", pp);*/
        Document d1 = new Document();
        d1.put("processNumber", 1);
        List<Document> list = iotdb.getCollection("process").find(query).sort(d1).into(new ArrayList<>());
        System.out.println("sss:" + list.size());
        list.forEach(e -> {
            String uuid = UUID.randomUUID().toString();
            ObjectId oldId = e.getObjectId("_id");
            Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(uuid), UuidRepresentation.JAVA_LEGACY));
            e.put("_id", bb);
            iotdb.getCollection("process").insertOne(e);
            Document del = new Document();
            del.put("_id", oldId);
            iotdb.getCollection("process").deleteOne(del);
        });

    }
}
