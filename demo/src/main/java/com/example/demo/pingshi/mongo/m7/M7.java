package com.example.demo.pingshi.mongo.m7;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.SneakyThrows;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2022/11/18 17:50
 */

public class M7 {

    @SneakyThrows
    public static void main(String[] args) {
        //参数 预设

        String startDate = "2022-11-16 13:42:39";
        String endDate = "2022-11-17 21:34:42";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        //db.getCollection('process').find({"processNumber":{$in:[30,50,180]},endTime:{$gt: ISODate("2022-11-16T13:42:39.520Z") , $lt:ISODate("2022-11-16T21:34:42.520Z")} })
        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document query = new Document();
        query.put("processNumber", Document.parse("{$in:[30,50,180]}"));
        Document et = new Document();
        et.put("$gte", sdf.parse(startDate));
        et.put("$lte", sdf.parse(endDate));
        query.put("endTime", et);

        List<Document> list = iotdb.getCollection("process").find(query).into(new ArrayList<>());
        System.out.println(list.size());
    }
}
