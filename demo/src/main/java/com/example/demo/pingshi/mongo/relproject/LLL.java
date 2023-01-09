package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 三坐标把double改成int
 * @date 2023/1/9 11:44
 */

public class LLL {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");

        List<Document> list = iotdb.getCollection("cmm").find().into(new ArrayList<>());
        list.forEach(e -> {
            Double typeD = Double.parseDouble(e.get("type").toString());
            int type = typeD.intValue();

            Double codeD = Double.parseDouble(e.get("code").toString());
            int code = codeD.intValue();
            int sn = 0;
            if (e.get("sn") != null) {
                Double snD = Double.parseDouble(e.get("sn").toString());
                sn = snD.intValue();
            }

            Document set = new Document();
            set.put("type", type);
            set.put("code", code);
            if (e.get("sn") != null) {
                set.put("sn", sn);
            }
            Document xx = new Document();
            xx.put("$set", set);
            Document query = new Document();
            query.put("_id", e.getObjectId("_id"));
            iotdb.getCollection("cmm").updateOne(query, xx);
        });

    }

    @Test
    public void xx() {
        System.out.println(Double.parseDouble("1.0"));
    }
}
