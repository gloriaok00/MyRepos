package com.example.demo.pingshi.siddhi.protobuf;

import io.siddhi.distribution.sample.grpc.Sweet;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class SweetSerializer implements Serializer<Sweet> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Sweet data) {
        try {
            return convertToBytes(data) ;
        } catch (IOException e) {
            throw new RuntimeException(e) ;
        }
    }

    @Override
    public void close() {
    }

    /**
     * Convert an instance of GEnrichedEventPayload to byte[]
     *
     * @return
     * @throws IOException
     */
    private byte[] convertToBytes(Sweet data) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        data.writeTo(output);
        return output.toByteArray();
    }
}
