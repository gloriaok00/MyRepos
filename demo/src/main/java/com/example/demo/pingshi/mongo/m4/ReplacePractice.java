package com.example.demo.pingshi.mongo.m4;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.util.UUID;

/**
 * @description 终于整明白了
 * db.getCollection('process').update({"_id" : JUUID("6ae607d7-4ef5-4575-a1d8-bb6945d9e596")},{"taskId" : JUUID("649c407e-d4e7-498c-af69-fa7a69a284d3"),
 * "processNumber" : 50.0,
 * "processName" : "合金的熔注"})
 * 这种的需要用replace，用update时必须要带"$set"这种操作符。不需要用操作符，直接在这里用update时一直报错。用replace就好了
 * <p>
 * updateOne for updating document fields using update operators.
 * You need replaceOne which takes the replacement document.
 * @date 2022/10/31 22:19
 */

public class ReplacePractice {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoDatabase database = mongoClient.getDatabase("Foo").withCodecRegistry(pojoCodecRegistry);
            MongoCollection<Document> collection = database.getCollection("process_tt_copy");
            FindIterable<Document> mm = collection.find();
            MongoCursor<Document> nn = mm.iterator();
            while (nn.hasNext()) {
                Document d = nn.next();
                BasicDBObject query = new BasicDBObject();
                Binary temp = new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(d.get("_id").toString()), UuidRepresentation.JAVA_LEGACY));
                query.append("_id", temp);
                //System.out.println(collection.find(query).first().toJson());
                Document doc = new Document();
                doc.put("taskId", new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(d.get("taskId").toString()), UuidRepresentation.JAVA_LEGACY)));
                doc.put("processNumber", d.getDouble("processNumber"));
                doc.put("processName", d.getString("processName"));
              /*  Document oo = new Document();
                oo.put("$set", doc);*/
                collection.replaceOne(query, doc);
            }

        }
    }
}
