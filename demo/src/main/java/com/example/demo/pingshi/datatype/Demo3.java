package com.example.demo.pingshi.datatype;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *  @description 对于基本数据类型的位数有点了解了
 *  @date 2019/12/11 13:31
 *  @date  2022/9/22 17:52
 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = {65, 66, 67, 68, 69};
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
