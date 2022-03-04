package com.example.demo.pingshi.protocol.p2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description TCP 传输的客户端
 * @date 2022-03-03 15:06
 */

public class ClientUpdate {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 10002);

        OutputStream out = socket.getOutputStream();

        out.write("tcp!".getBytes());

        // 读取服务端返回的数据，使用 Socket 读取流
        InputStream in = socket.getInputStream();
        byte[] buf = new byte[1024];

        int len = in.read(buf);

        String text = new String(buf, 0, len);

        System.out.println(text);

        socket.close();
    }
}
