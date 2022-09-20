package com.example.demo.pingshi.io.o1;

import org.apache.commons.compress.utils.IOUtils;
import org.junit.Test;

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

    //AutoCloseable
    @Test
    public void show() throws Exception {
        try (InputStream inputStream = new FileInputStream("/Users/zhangyu/Desktop/test.txt")) {
            int n;
            while ((n = inputStream.read()) != -1) {
                System.out.println(n);
            }
        }
    }

    @Test
    public void readFile() throws IOException {
        try (InputStream input = new FileInputStream("/Users/zhangyu/Desktop/test.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }
    }

    @Test
    public void show1() throws IOException {

        InputStream inputStream = new FileInputStream("/Users/zhangyu/Desktop/test.txt");
        OutputStream outputStream = new FileOutputStream("/Users/zhangyu/file-2.txt");
        byte[] bs = IOUtils.toByteArray(inputStream);
        for (byte b : bs) {
            outputStream.write(b);
        }
        inputStream.close();
        outputStream.close();
    }

    /*
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     */
    @Test
    public void readFileByBytes() {
        String inFile = "/Users/zhangyu/Desktop/test.txt";
        String outFile = "/Users/zhangyu/file-3.txt";
        InputStream in = null;
        OutputStream out = null;
        try {
            byte[] tempbytes = new byte[100];
            int byteread = 0;
            in = new FileInputStream(inFile);
            out = new FileOutputStream(outFile);
            while ((byteread = in.read(tempbytes)) != -1) {
                out.write(tempbytes, 0, byteread);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
                try {
                    out.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    @Test
    public void readAndWrite() {
        Long start = System.currentTimeMillis();
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/zhangyu/Music/我的音乐/爱情这样开始.mp3"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/zhangyu/爱情这样开始.mp3"));
            byte[] b = new byte[1024];
            int len = 0;
            while (-1 != (len = bis.read(b, 0, b.length))) {
                bos.write(b, 0, len);
            }
            Long end = System.currentTimeMillis();
            System.out.println((end - start) + "ms");
        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readWithByteArray() throws IOException {
        FileInputStream inFile = new FileInputStream("/Users/zhangyu/Music/我的音乐/老地方.wav");
        ByteArrayInputStream in = null;
        ByteArrayOutputStream out = null;

        FileOutputStream outFile = new FileOutputStream("/Users/zhangyu/老地方.wav");

        try {

            in = new ByteArrayInputStream(IOUtils.toByteArray(inFile));
            out = new ByteArrayOutputStream();

            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = in.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, len);
            }
            out.writeTo(outFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
