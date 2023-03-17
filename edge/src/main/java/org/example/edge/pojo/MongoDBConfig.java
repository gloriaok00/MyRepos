package org.example.edge.pojo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mongodb配置工具类
 */

@Slf4j
@Component
public class MongoDBConfig {

    public String ip;

    public int port;

    @Value("${sl.mongodb.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Value("${sl.mongodb.port}")
    public void setPort(int port) {
        this.port = port;
    }

    public static MongoClient mongoClient;

    public static ConcurrentHashMap<String, MongoDatabase> mongoDBs = new ConcurrentHashMap<>();

    @PostConstruct
    public void loadMongoDBs() {
        mongoClient = new MongoClient(ip, port);
        log.info("sw mongodb connected");
        ArrayList<String> dbNames = mongoClient.listDatabaseNames().into(new ArrayList<>());
        dbNames.forEach(dbName -> {
            if (dbName.startsWith("tenant-") || dbName.equals("iot")) {
                mongoDBs.put(dbName, mongoClient.getDatabase(dbName));
            }
        });
    }

    //仅获取租户数据库，不含IOT-zh
    public static MongoDatabase getCurrentMongoDB(String tenantToken) {
        MongoDatabase currentDB = MongoDBConfig.mongoDBs.get("tenant-" + tenantToken);
        //在项目启动后创建的租户，加载其数据并放入到ConcurrentHashMap中
        if (currentDB == null) {
            MongoDBConfig.mongoDBs.put("tenant-" + tenantToken, MongoDBConfig.mongoClient.getDatabase("tenant-" + tenantToken));
        }
        return MongoDBConfig.mongoDBs.get("tenant-" + tenantToken);
    }

}
