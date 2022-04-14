package com.example.demo.pingshi.pwd;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description
 * @date 2022-01-05 15:37
 */

public class MD5Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 创建一个MessageDigest实例:
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md5.update("Hello".getBytes(StandardCharsets.UTF_8));
        md5.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = md5.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
