package com.example.demo.pingshi.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangyu
 * @date 2019/12/11 13:31
 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = {65, 66, 67, 68, 69};
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
