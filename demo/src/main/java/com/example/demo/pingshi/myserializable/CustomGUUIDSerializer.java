package com.example.demo.pingshi.myserializable;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.sitewhere.grpc.model.CommonModel;

import java.lang.reflect.Type;
import java.util.UUID;

public class CustomGUUIDSerializer implements JsonSerializer<CommonModel.GUUID> {

    @Override
    public JsonElement serialize(CommonModel.GUUID guuid, Type typeOfSrc, JsonSerializationContext context) {
        System.out.println("guuid序列化:"+asApiUuid(guuid).toString());
        return new JsonPrimitive(asApiUuid(guuid).toString());
    }

    public static UUID asApiUuid(CommonModel.GUUID grpc){
        if (grpc == null) {
            return null;
        }
        return new UUID(grpc.getMsb(), grpc.getLsb());
    }
}
