package org.example.edge;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Service;
import org.wso2.carbon.siddhi.editor.core.util.designview.beans.EventFlow;
import org.wso2.carbon.siddhi.editor.core.util.designview.deserializers.DeserializersRegisterer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

@Slf4j
@Service("edgeService")
public class EdgeServiceImpl implements EdgeService {

    /**
     * 获取mx xml
     */
    @Override
    public String getMxXml(MxXmlRequest req) {

        String eventFlowJson = new String(Base64.getDecoder().decode(req.getContent()), StandardCharsets.UTF_8);
        Gson gson = DeserializersRegisterer.getGsonBuilder().disableHtmlEscaping().create();
        EventFlow eventFlow = gson.fromJson(eventFlowJson, EventFlow.class);
        return MxDom4jXml.createXml(eventFlow);

    }

    /**
     * 获取边缘计算中文信息
     */
    @Override
    public JSONObject getZh() {
        JSONObject result = new JSONObject();
        //source
        MongoCollection<Document> iotCollect = MongoDBConfig.mongoDBs.get("iot").getCollection("zh");
        Document show = new Document();
        show.put("_id", 0);
        show.put("name", 1);
        show.put("parameters", 1);
        AggregateIterable<Document> docs_source = iotCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "source")),
                        Aggregates.project(show)
                )
        );
        result.put("sources", docs_source.into(new ArrayList<>()));

        //sink
        AggregateIterable<Document> docs_sink = iotCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "sink")),
                        Aggregates.project(show)
                )
        );
        result.put("sinks", docs_sink.into(new ArrayList<>()));

        //store
        AggregateIterable<Document> docs_store = iotCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "store")),
                        Aggregates.project(show)
                )
        );
        result.put("stores", docs_store.into(new ArrayList<>()));

        //sourceMap
        AggregateIterable<Document> docs_sourceMap = iotCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "sourceMap")),
                        Aggregates.project(show)
                )
        );
        result.put("sourceMap", docs_sourceMap.into(new ArrayList<>()));

        //sinkMap
        AggregateIterable<Document> docs_sinkMap = iotCollect.aggregate(
                Arrays.asList(
                        Aggregates.match(new Document("type", "sinkMap")),
                        Aggregates.project(show)
                )
        );
        result.put("sinkMap", docs_sinkMap.into(new ArrayList<>()));
        return result;
    }

}
