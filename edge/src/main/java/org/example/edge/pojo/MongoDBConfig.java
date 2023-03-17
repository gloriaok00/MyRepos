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

    public String port;

    public String replicaSetName;

    @Value("${sl.mongodb.max-connection-idle-time}")
    public int maxConnectionIdleTime;

    @Value("${sl.mongodb.active-replicate}")
    public boolean activeReplicate;

    @Value("${sl.mongodb.application-name}")
    public String applicationName;

    @Value("${sl.mongodb.ip}")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Value("${sl.mongodb.port}")
    public void setPort(String port) {
        this.port = port;
    }

    @Value("${sl.mongodb.replicated-name}")
    public void setReplicaSetName(String replicaSetName) {
        this.replicaSetName = replicaSetName;
    }

    public static MongoClient mongoClient;

    public static ConcurrentHashMap<String, MongoDatabase> mongoDBs = new ConcurrentHashMap<>();

    MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

    @PostConstruct
    public void loadMongoDBs() {
        builder.maxConnectionIdleTime(maxConnectionIdleTime);
        builder.applicationName(applicationName);
        List<ServerAddress> addresses = parseServerAddresses();
        if (activeReplicate) {
            builder.requiredReplicaSetName(replicaSetName);
            mongoClient = new MongoClient(addresses, builder.build());
        } else {
            mongoClient = new MongoClient(addresses.get(0), builder.build());
        }
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

    //将主机名和端口解析为地址列表
    protected List<ServerAddress> parseServerAddresses() {
        String[] hosts = ip.split(",");
        String[] ports = port.split(",");

        List<ServerAddress> addresses = new ArrayList<ServerAddress>();
        for (int i = 0; i < hosts.length; i++) {
            if (ports.length == 1) {
                addresses.add(new ServerAddress(hosts[i].trim(), Integer.parseInt(port)));
            } else {
                addresses.add(new ServerAddress(hosts[i].trim(), Integer.parseInt(ports[i].trim())));
            }
        }
        return addresses;
    }
}
