package com.example.demo.pingshi.myserializable;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeserializer implements JsonDeserializer<Date> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date deserialize(JsonElement dateStr, Type typeOfSrc, JsonDeserializationContext context) {
        try {
            System.out.println("这是反序列化");
            System.out.println(dateStr.getAsString());
            return dateFormat.parse(dateStr.getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
