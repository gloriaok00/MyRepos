package com.example.demo.pingshi.pwd.sha;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @description
 * @date 2022-04-22 22:42
 */

public class SHA256Demo {

    //Java代码实现SHA-256消息加密
    public static String getSHA256(String data) throws Exception {

        //返回实现指定摘要算法的MessageDigest对象。
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        //使用指定的字节更新摘要
        md.update(data.getBytes(StandardCharsets.UTF_8));
        //通过执行最后的操作（如填充）来完成哈希计算
        byte[] array = md.digest();
        StringBuilder sb = new StringBuilder();
        //对哈希数进行密码散列计算
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF)|0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getSHA256("admin"));
    }
}
