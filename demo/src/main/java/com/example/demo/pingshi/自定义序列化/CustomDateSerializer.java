package com.example.demo.pingshi.自定义序列化;
 
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class CustomDateSerializer implements JsonSerializer<Date> {
 
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
        System.out.println("这是序列化");
        System.out.println(date.toString());
        return new JsonPrimitive(dateFormat.format(date));
    }
}