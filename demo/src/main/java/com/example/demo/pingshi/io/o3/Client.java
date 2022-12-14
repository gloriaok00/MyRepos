package com.example.demo.pingshi.io.o3;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Socket s = new Socket("127.0.0.1", 1234);

                    //构建IO
                    OutputStream os = s.getOutputStream();

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                    //向服务器端发送一条消息
                    bw.write("消息\n");
                    bw.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        r.run();
    }
}
