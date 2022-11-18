package com.example.demo.pingshi.mongo.m7;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @date 2022/11/18 17:50
 */

public class M8 {

    public static void main(String[] args) {
        //db.getCollection('process').find({"processNumber":{$in:[30,50,180]},endTime:{$gt: ISODate("2022-11-16T13:42:39.520Z") , $lt:ISODate("2022-11-16T21:34:42.520Z")} })
        MongoClient client = new MongoClient("localhost:27017");
        MongoDatabase iotdb = client.getDatabase("Foo");
        Document query=new Document();
        query.put("processNumber",Document.parse("{$in:[30,50,180]}"));

        query.put("endTime",Document.parse("{$gt: ISODate(\"2022-11-16T13:42:39.520Z\") , $lt:ISODate(\"2022-11-16T21:34:42.520Z\")}"));

        List<Document> list = iotdb.getCollection("process").find(query).into(new ArrayList<>());
        System.out.println(list.size());
    }
}
