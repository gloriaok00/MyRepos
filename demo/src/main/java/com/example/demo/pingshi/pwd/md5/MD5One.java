package com.example.demo.pingshi.pwd.md5;

import cn.hutool.crypto.digest.DigestUtil;
import org.junit.Test;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description MD5练习 哈希算法中的一种实现 没有盐
 * @date 2022-04-22 16:58
 */

public class MD5One {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //创建一个MessageDigest实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //反复调用update输入数据
        md5.update("Hello".getBytes(StandardCharsets.UTF_8));
        md5.update("World".getBytes(StandardCharsets.UTF_8));
        byte[] result = md5.digest();
        //转换为十六进制的字符串
        System.out.println(new BigInteger(1, result).toString(16));
    }

    @Test
    public void MD5Test() {
        String password = "abc123456";
        String md5 = DigestUtil.md5Hex(password);
        System.out.println("md5 = " + md5);
    }

}
