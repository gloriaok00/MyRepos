package com.example.demo.pingshi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Random;

public class MongoDBJDBC {
    public static void main(String args[]) {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
            MongoCollection<Document> myCollect = mongoDatabase.getCollection("F1");
            // 新增数据
            for (int i = 0; i < 10; i++) {
                Document temp = new Document();
                Random r=new Random();
                temp.put("age", r.nextInt());
                myCollect.insertOne(temp);
            }

            //查
            //db.F2.aggregate([{$project:{_id:0,name:1,desc:1,description:{$add:"$desc"},type:1,dataType:{$add:"$type"}}}])
           /* Document desc=new Document();
            desc.put("add","1");*/
           /* Document dataType=new Document();
            dataType.put("add","2");
            show.put("dataType",dataType);*/
           /* Document show=new Document();
            show.put("_id",0);
            show.put("name",1);
            show.put("desc",1);
            //show.put("description","desc");
            show.put("type",1);*/

            /*AggregateIterable<Document> output = collection.aggregate(Arrays.asList(
                    new Document("$unwind", "$views"),
                    new Document("$match", new Document("views.isActive", true)),
                    new Document("$sort", new Document("views.date", 1)),
                    new Document("$limit", 200),
                    new Document("$project", new Document("_id", 0)
                            .append("url", "$views.url")
                            .append("date", "$views.date"))
            ));*/
            /*Document show =new Document();
            Document project=new Document();
            project.put("_id",0);
            project.put("name",1);
            project.put("desc",1);
            project.put("description",new Document("$add","$desc"));
            project.put("type",1);
            project.put("dataType",new Document("$add","$type"));
            show.put("$project",project);
            List<Document> pipeline = Arrays.asList(show);
            ArrayList<Document> resultList=myCollect.aggregate(pipeline).into(new ArrayList<>());
            System.out.println(resultList.size());*/


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
