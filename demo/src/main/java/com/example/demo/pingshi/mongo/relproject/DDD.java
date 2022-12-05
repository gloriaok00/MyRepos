package com.example.demo.pingshi.mongo.relproject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 为壁厚数据增加sn
 * @date 2022/12/5 18:21
 */

public class DDD {

    @SneakyThrows
    public static void main(String[] args) {

        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document d1 = new Document();
        d1.put("code", 3);

        List<Document> list = iotdb.getCollection("thick").find(d1).into(new ArrayList<>());
        list.forEach(e -> {
            Document query = new Document();
            query.put("_id", e.getObjectId("_id"));
            String[] nn = e.getString("name").split("内环");
            String vv1 = nn[1]+"-"+(new Integer(nn[1])+1)+"间";
            String vv2 = "8-1间";
            Document set = new Document();
            if (e.getDouble("sn") == 8) {
                System.out.println("vv2:" + vv2);
                set.put("name", vv2);
            } else {
                System.out.println("vv1:" + vv1);
                set.put("name", vv1);
            }
            Document xx = new Document();
            xx.put("$set", set);
            iotdb.getCollection("thick").updateOne(query, xx);
        });

    }
}
