package com.example.demo.pingshi.kafka.sw;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sitewhere.grpc.model.DeviceEventModel;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class GEnrichedEventPayloadDeserializer implements Deserializer<DeviceEventModel.GEnrichedEventPayload> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public DeviceEventModel.GEnrichedEventPayload deserialize(String topic, byte[] data) {
        try {
            return parseFromBytes(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
    }

    /**
     * parse an instance of GEnrichedEventPayload from byte stream
     *
     * @param payload
     * @return
     * @throws InvalidProtocolBufferException
     */
    private static DeviceEventModel.GEnrichedEventPayload parseFromBytes(byte[] payload) throws InvalidProtocolBufferException {
        DeviceEventModel.GEnrichedEventPayload grpc = DeviceEventModel.GEnrichedEventPayload.parseFrom(payload);
        return grpc;
    }
}
