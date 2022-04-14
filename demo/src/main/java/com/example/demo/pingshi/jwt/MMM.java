package com.example.demo.pingshi.jwt;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @description
 * @date 2022-01-18 08:51
 */

public class MMM {

    public static void main(String[] args) throws Exception{
        //System.out.println("Hello".hashCode());
        //System.out.println("Hello2321323".hashCode());
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
