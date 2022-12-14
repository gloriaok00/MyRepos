package com.example.demo.pingshi.io.o3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(1234);
                    while (true) {
                        System.out.println("服务器准备接收数据中..");
                        Socket s = ss.accept();
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        //读取客户端发送来的消息
                        String mess = br.readLine();
                        System.out.println("读取外来的消息:" + mess);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
