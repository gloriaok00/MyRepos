package com.example.demo.pingshi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.util.UUID;

/**
 * @author zhangyu
 * @description   mongo db 查询 binary类型 id
 * @date 2020-11-30 14:57
 */

public class MongoBinanyDemo {
    public static void main( String args[] ){
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "118.113.164.51" , 30708 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("tenant-zy2");
            MongoCollection<Document> collection = mongoDatabase.getCollection("devicetypes");
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }

            //Document searchById = new Document("_id", new Binary((byte) 3, Base64.getDecoder().decode("009wZqTWYMB8aQPasIPquw==")));

            Document searchById = new Document("_id", new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString("4f218f5f-d749-4033-b970-54e21926a814"), UuidRepresentation.JAVA_LEGACY)));
            FindIterable<Document> findIterable1 = collection.find(searchById);
            MongoCursor<Document> mongoCursor1 = findIterable1.iterator();
            while(mongoCursor1.hasNext()){
                System.out.println("结果:"+mongoCursor1.next());
            }

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
