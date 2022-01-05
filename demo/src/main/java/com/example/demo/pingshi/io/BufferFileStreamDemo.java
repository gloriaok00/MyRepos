package com.example.demo.pingshi.io;

import java.io.*;

/**
 * @author zhangyu
 * @date 2019/11/23 16:51
 */
public class BufferFileStreamDemo {

    public static void main(String[] args) {
       /*
        try{
           FileOutputStream fos=new FileOutputStream("src/main/java/com/example/demo/pingshi/io/iotestfile.txt");
           BufferedOutputStream bos=new BufferedOutputStream(fos);
           bos.write("把数据写入硬盘中".getBytes());
           bos.flush();
           bos.close();
       }catch (Exception e){
           e.printStackTrace();
       }
     */


        try {
            FileInputStream fis = new FileInputStream("src/main/java/com/example/demo/pingshi/io/iotestfile.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            /*int len = 0;
            while ((len = bis.read()) != -1) {
                System.out.println(len);
            }*/
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
