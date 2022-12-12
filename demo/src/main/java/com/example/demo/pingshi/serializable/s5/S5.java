package com.example.demo.pingshi.serializable.s5;

import com.alibaba.fastjson.JSONObject;

/**
 * @description
 * @date 2022/12/12 14:52
 */

public class S5 {

    public static void main(String[] args) {
        JSONObject jObj = new JSONObject();
        jObj.put("id", 1);
        jObj.put("name", "zzz");
        jObj.put("ooo", 171);
        Person p1 = jObj.toJavaObject(Person.class);
        System.out.println(p1);
    }
}
