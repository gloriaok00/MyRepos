package com.example.demo.pingshi.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhangyu
 * @date 2019-11-23 11:43
 */
public class FileStreamDemo {
    public static void main(String[] args) {

        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //fos = new FileOutputStream("/Users/zhangyu/IdeaProjects/BackRepos/demo/src/main/java/com/example/demo/pingshi/io/iotestfile.txt");
            //fos = new FileOutputStream("iotestfile.txt");
            fos = new FileOutputStream("src/main/java/com/example/demo/pingshi/io/iotestfile.txt");
            byte[] bytes = {65, 66, 67, 68, 69};
            // fos.write(bytes,1,2);
            fos.write(bytes);
            fos.close();

            fis = new FileInputStream("src/main/java/com/example/demo/pingshi/io/iotestfile.txt");
            /*int len=0;
            while((len=fis.read())!=-1){
                System.out.println(len);
            }*/
            int ss = fis.read(bytes);
            System.out.println(new String(String.valueOf(ss)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
