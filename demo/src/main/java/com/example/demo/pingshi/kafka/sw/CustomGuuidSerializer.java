package com.example.demo.pingshi.kafka.sw;

import com.example.demo.pingshi.kafka.sw.pojo.Guuid;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author zhangyu
 * @description 自定义序列化器 把guuid转成uuid
 * @date 2020-08-28 14:28
 */
public class CustomGuuidSerializer implements JsonSerializer<Guuid> {

    @Override
    public JsonElement serialize(Guuid guuid, Type typeOfSrc, JsonSerializationContext context) {
        BigDecimal mostBigDecimal = new BigDecimal(guuid.getMsb());
        BigDecimal leastBigDecimal = new BigDecimal(guuid.getLsb());
        return new JsonPrimitive(new UUID(mostBigDecimal.longValue(), leastBigDecimal.longValue()).toString());
    }

}
