package com.example.demo.pingshi.mytrans.t1;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @description
 * @date 2022/5/29 23:37
 */

@Component
public class TransM {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transMongo(){
        //步骤1
        MongoClient mongoClient=new MongoClient("127.0.0.1");
        MongoDatabase db=mongoClient.getDatabase("Foo");
        MongoCollection col=db.getCollection("f1");
        Document doc=new Document();
        doc.put("name","transLearn");
        doc.put("time",new Date());
        col.insertOne(doc);
    }
}
