package com.example.demo.pingshi.io.o1;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @description io随机练习
 * @date 2022/9/20 02:43
 */

public class G3 {

    public static void main(String[] args) throws IOException {
        String str = "for tonight i am yours.. so deny the truth";
        byte[] bs = str.getBytes(StandardCharsets.UTF_8);
        OutputStream os = new FileOutputStream("/Users/zhangyu/file-1.txt");
        for (byte b : bs) {
            os.write(b);
        }
        os.close();
    }
}
