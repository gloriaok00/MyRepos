package com.example.demo.pingshi.io.o1;

import org.apache.commons.compress.utils.IOUtils;

import java.io.*;

/**
 * @description
 * @date 2022/9/20 02:53
 */

public class G2 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("/Users/zhangyu/Desktop/test.txt");
        OutputStream outputStream = new FileOutputStream("/Users/zhangyu/file-2.txt");
        byte[] bs = IOUtils.toByteArray(inputStream);
        for (byte b : bs) {
            outputStream.write(b);
        }
        inputStream.close();
        outputStream.close();
    }
}
