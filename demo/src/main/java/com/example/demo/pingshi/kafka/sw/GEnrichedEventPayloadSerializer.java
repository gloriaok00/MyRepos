package com.example.demo.pingshi.kafka.sw;

import com.sitewhere.grpc.model.DeviceEventModel;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class GEnrichedEventPayloadSerializer implements Serializer<DeviceEventModel.GEnrichedEventPayload> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, DeviceEventModel.GEnrichedEventPayload data) {
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
    private byte[] convertToBytes(DeviceEventModel.GEnrichedEventPayload data) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        data.writeTo(output);
        return output.toByteArray();
    }
}
