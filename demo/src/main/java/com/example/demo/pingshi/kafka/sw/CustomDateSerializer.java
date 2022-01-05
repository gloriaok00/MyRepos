package com.example.demo.pingshi.kafka.sw;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangyu
 * @description 自定义序列化器 把xx转成date yyyy-MM-dd HH:mm:ss.SSS
 * @date 2020-09-01 09:34
 */
public class CustomDateSerializer implements JsonSerializer<Long> {

    @Override
    public JsonElement serialize(Long timeMillis, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return new JsonPrimitive(sdf.format(new Date(timeMillis)));
    }

}
