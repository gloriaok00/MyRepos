package com.example.demo.pingshi.b64;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @description base64学习
 * @date 2022/5/13 13:27
 */

public class B64 {
    public static void main(String[] args) {
        String e = "我是伪证";
        String s = Base64.getEncoder().encodeToString(e.getBytes(StandardCharsets.UTF_8));
        System.out.println(s);
        String s1 = new String(Base64.getDecoder().decode(s));
        System.out.println(s1);
    }
}
