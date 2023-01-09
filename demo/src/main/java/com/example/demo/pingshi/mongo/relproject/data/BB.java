package com.example.demo.pingshi.mongo.relproject.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description 录入新批次
 * @date 2022/10/24 11:42
 */

@Slf4j
public class BB {

    @SneakyThrows
    @Test
    public void kk() {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");

        //insert data
        Document doc = new Document();
        Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.randomUUID(), UuidRepresentation.JAVA_LEGACY));
        doc.put("_id", bb);
        //taskNumber
        doc.put("taskNumber", "22-11-11");
        //batchNumberDown
        doc.put("batchNumberDown", "22-11-11");
        //partName
        doc.put("partName", "斜支板承力框架_铸件");
        //partNumber
        doc.put("partNumber", "S10.41.1001G-Z");
        //batchType
        doc.put("batchType", 1);
        //检测人
        doc.put("inspector", "JJZ03");
        //核验人
        doc.put("verifier", "JJZ02");
        //设备名称
        doc.put("deviceName", "三坐标测量机");
        //型号/规格
        doc.put("deviceModel", "GLOBAL STATUS 9.9.8");
        //温度
        doc.put("temperature", 21.2);
        //相对湿度
        doc.put("humidity", 39);

        iotdb.getCollection("task").insertOne(doc);

    }


    //改double为int
    @Test
    public void cc() {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        List<Document> list = iotdb.getCollection("task").find().into(new ArrayList<>());

        list.forEach(e -> {
            Binary bb = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(e.get("_id").toString()), UuidRepresentation.JAVA_LEGACY));
            Document query = new Document();
            query.put("_id", bb);
            Document doc = new Document();
            Document set = new Document();
            Double batchType = e.getDouble("batchType");
            set.put("batchType", batchType.intValue());
            doc.put("$set", set);
            iotdb.getCollection("task").updateOne(query, doc);
        });

    }

}
