package com.example.demo.pingshi.mongo.m3;

import org.bson.BSONDecoder;
import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;

import java.io.*;

/**
 * @description 读取bson
 * @date 2022/5/23 00:47
 */

public class M3 {

    /**
     * 读取mongoDB的文件bson文件
     */
    private void readBsonFile(String path) {
        File file = new File(path);
        int count = 0;
        InputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            BSONDecoder decoder = new BasicBSONDecoder();
            while (inputStream.available() > 0) {
                BSONObject obj = decoder.readObject(inputStream);
                if(obj == null){
                    break;
                }
                System.out.println(obj);
                count++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
        System.err.println(String.format("%s objects read", count));
    }

    public static void main(String[] args) {
        M3 m3=new M3();
        m3.readBsonFile("/Users/zhangyu/tenant-0002/assets.bson");
    }
}
