package com.example.demo.pingshi.pwd;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description BCryptPwd加密原理学习中..
 * @date 2022-02-05 21:19
 */

public class BCryptPwd {
    public static void main(String[] args) {

        String password="123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encode1 = bCryptPasswordEncoder.encode(password);
        System.out.println("encode1:" + encode1);

        boolean matches1 = bCryptPasswordEncoder.matches(password, encode1);
        System.out.println("matches1:" + matches1);

        String encode2 = bCryptPasswordEncoder.encode(password);
        System.out.println("encode2:" + encode2);

        boolean matches2 = bCryptPasswordEncoder.matches(password, encode2);
        System.out.println("matches2:" + matches2);
    }
}
