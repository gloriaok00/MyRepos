package com.example.demo.pingshi.rest;

import cn.hutool.http.HttpRequest;

import java.util.HashMap;

/**
 * @description
 * @date 2022/9/20 17:38
 */

public class FormReq {

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("grant_type", "password");
        map.put("username", "super_admin");
        map.put("password", "super_admin");
        map.put("tenantId", 1L);
        String result = HttpRequest.post("http://223.223.176.32:30717/oauth/token")
                .basicAuth("iot_web", "iot_web")
                .form(map)
                .execute().body();
        System.out.println("结果:" + result);
    }
}
