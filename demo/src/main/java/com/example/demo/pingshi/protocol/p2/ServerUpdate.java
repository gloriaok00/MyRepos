package com.example.demo.pingshi.protocol.p2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @description TCP 传输的服务端
 * @date 2022-03-03 15:08
 */
public class ServerUpdate {
    public static void main(String[] args) throws IOException {

        // 1、创建服务端对象
        ServerSocket ss = new ServerSocket(10002);

        // 2、获取连接过来的客户端对象
        Socket s = ss.accept();  // accept 方式为阻塞式方法

        String ip = s.getInetAddress().getHostAddress();

        // 3、通过 Socket 对象获取输入流，要读取客户端发来的数据
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(ip + ":" + text);

        // 使用客户端的 Socket 对象的输出流给客户端返回数据
        OutputStream out = s.getOutputStream();
        out.write("收到".getBytes());

        s.close();
        ss.close();
    }
}
