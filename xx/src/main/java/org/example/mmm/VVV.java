package org.example.mmm;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.bson.Document;
import org.bson.UuidRepresentation;
import org.bson.internal.UuidHelper;
import org.bson.types.Binary;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @description  处理老数据临时用
 * @date 2022-04-14 13:35
 */

public class VVV {

    public static void main(String[] args) throws Exception{
        MinioClient minioClient=new MinioClient("http://223.223.176.32:30711","OKw3bxT5me","AnI22zu!vu89FaJ");
        MongoClient mongoClient=new MongoClient("223.223.176.32",30708);
        MongoDatabase db=mongoClient.getDatabase("tenant-0001");
        ArrayList<Document> docs=db.getCollection("formula").find().projection(Projections.include("url")).into(new ArrayList<>());
        docs.forEach(e->{
            String[] strs=e.get("url").toString().split("/");
            String fileName=strs[strs.length-1];
            String[] pdfNames=fileName.split(".xlsx");
            System.out.println(pdfNames[0]);
            try {
                InputStream is=minioClient.getObject("model","/0001/formula/"+pdfNames[0]+".pdf");
               // System.out.println(is.toString());
                PutObjectOptions putObjectOptions = new PutObjectOptions(-1, 5242880L);
                minioClient.putObject("iot","/0001/formula/pdf/"+pdfNames[0]+".pdf",is,putObjectOptions);
                System.out.println(pdfNames[0]+".pdf"+" 已上传完毕");
                //修改数据
                BasicDBObject query = new BasicDBObject();
                query.put("_id", new Binary((byte) 3, UuidHelper.encodeUuidToBinary(UUID.fromString(e.get("_id").toString()), UuidRepresentation.JAVA_LEGACY)));

                BasicDBObject newDocument = new BasicDBObject();
                newDocument.put("url", "/iot/0001/technology/xls/"+fileName);

                BasicDBObject updateObject = new BasicDBObject();
                updateObject.put("$set", newDocument);

                db.getCollection("technologytemplates").updateOne(query, updateObject);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }
}
