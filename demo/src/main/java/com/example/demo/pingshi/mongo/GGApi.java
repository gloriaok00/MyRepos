package com.example.demo.pingshi.mongo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.http.HttpUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;


/**
 * @author zhangyu
 * @description  通过Mongo取数据，然后翻译，然后入库
 * @date 2021-08-26 11:16
 */

public class GGApi {

    public static void main(String args[]) throws Exception {

        // 连接到 mongodb 服务
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // 连接到数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Foo");
        MongoCollection<Document> myCollect = mongoDatabase.getCollection("test1");
        ArrayList<Document> dd=myCollect.find(Filters.eq("type","sinkMap")).into(new ArrayList<>());
        //GT g = GT.getInstance();
        for (Document e : dd) {
           ArrayList<Document> pp=(ArrayList<Document>)e.get("parameters");
            for (Document p : pp) {
                System.out.println("===========");
                System.out.println(e.getString("name")+"-"+p.getString("name"));
                //gg api
                String txt=p.getString("name").replace(".","%20");
                System.out.println("txt:"+txt);
                String gt= HttpUtil.httpget("https://fanyi.youdao.com/translate?&doctype=json&type=AUTO&i="+txt,null,null);
                JSONObject obj=JSONObject.parseObject(gt);
                JSONObject sss=obj.getJSONArray("translateResult").getJSONArray(0).getObject(0,JSONObject.class);
                System.out.println(sss.getString("tgt"));
                String tgt=sss.getString("tgt");
                Document query=new Document();
                query.put("type","sinkMap");
                query.put("name",e.getString("name"));
                query.put("parameters.name",p.getString("name"));
                myCollect.updateOne(query,new Document("$set",new Document("parameters.$.zhName",tgt)));
                Thread.sleep(1000);
            }
        }
    }
}
