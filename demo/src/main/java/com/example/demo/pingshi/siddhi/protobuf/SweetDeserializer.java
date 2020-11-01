package com.example.demo.pingshi.siddhi.protobuf;

import io.siddhi.distribution.sample.grpc.Sweet;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class SweetDeserializer implements Deserializer<Sweet> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public Sweet deserialize(String topic, byte[] data) {
        try {
            return parseFromBytes(data) ;
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public void close() {
    }

    /**
     * parse an instance of GEnrichedEventPayload from byte stream
     * @param payload
     * @return
     * @throws Exception
     */
    private static Sweet parseFromBytes(byte[] payload) throws Exception {
        Sweet grpc = Sweet.parseFrom(payload);
        return grpc ;
    }
}
