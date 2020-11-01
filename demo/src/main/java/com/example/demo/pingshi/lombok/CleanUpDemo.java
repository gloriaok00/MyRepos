package com.example.demo.pingshi.lombok;

import lombok.Cleanup;

import java.io.*;

/**
 * @author zhangyu
 * @description @Cleanup最佳实线
 * @date 2020-09-23 11:55
 */

public class CleanUpDemo {
    public static void main(String[] args) throws Exception{
        @Cleanup
        OutputStream outStream = new FileOutputStream(new File("./src/main/resources/text.txt"));
        @Cleanup
        InputStream inStream = new FileInputStream(new File("./src/main/resources/text2.txt"));
        byte[] b = new byte[65536];
        while (true) {
            int r = inStream.read(b);
            if (r == -1) break;
            outStream.write(b, 0, r);
        }
    }
}
