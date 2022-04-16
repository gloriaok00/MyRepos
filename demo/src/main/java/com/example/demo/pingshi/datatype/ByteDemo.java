package com.example.demo.pingshi.datatype;

import java.nio.charset.StandardCharsets;

/**
 * @description  字节数
 * @date 2022-01-05 15:01
 */

public class ByteDemo {

    public static void main(String[] args) {
        byte[] bytes="123".getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);
        for (byte b : bytes) {
            System.out.println(b);
        }
        int i=1;
        byte[] bs=String.valueOf(i).getBytes();
        for (byte b : bs) {
            System.out.println(b);
        }
        //System.out.println(Arrays.toString("a".getBytes(StandardCharsets.UTF_8)));
    }
}
