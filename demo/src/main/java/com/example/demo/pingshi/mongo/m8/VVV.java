package com.example.demo.pingshi.mongo.m8;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @description 录工序数据
 * @date 2022/11/18 17:50
 */

public class VVV {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document query = new Document();
        Document a1 = new Document();
        a1.put("$gt", 40);
        //a1.put("$lte", 40);
        query.put("processNumber", a1);
        query.put("taskNumber", "22-10-9");
        Document d1 = new Document();
        d1.put("processNumber", 1);
        List<Document> list = iotdb.getCollection("process").find(query).sort(d1).into(new ArrayList<>());
        System.out.println("ooo:" + list);
        System.out.println("sss:" + list.size());
        list.forEach(e -> {
            Document tt = new Document();
            Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString("e6b8b7e2-97cb-4bff-b765-9ed6775e3e2e"), UuidRepresentation.JAVA_LEGACY));
            tt.put("taskId", bb);
            tt.put("taskNumber", "22-10-10");
            tt.put("processNumber", e.getDouble("processNumber"));
            tt.put("processName", e.getString("processName"));
            Date sd = e.getDate("startTime");
            tt.put("startTime", new Date(sd.getYear(), sd.getMonth(), sd.getDate() + 1, sd.getHours(), sd.getMinutes(), sd.getSeconds()));
            Date ed = e.getDate("endTime");
            tt.put("endTime", new Date(ed.getYear(), ed.getMonth(), ed.getDate() + 1, ed.getHours(), ed.getMinutes(), ed.getSeconds()));
            iotdb.getCollection("process").insertOne(tt);
        });

    }
}
