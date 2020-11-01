package com.example.demo.pingshi.io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangyu
 * @date 2019/12/11 13:31
 */
public class Demo3 {

    public static void main(String[] args) throws IOException {
        byte[] bytes = {65, 66, 67, 68, 69};
        //FileOutputStream fileOutputStream = new FileOutputStream(new File("./test.txt"));
        FileOutputStream fileOutputStream = new FileOutputStream("./test.txt");
        // 写入二进制文件，直接打开会出现乱码
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }
}
