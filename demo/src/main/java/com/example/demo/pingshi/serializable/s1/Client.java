package com.example.demo.pingshi.serializable.s1;

import com.example.demo.pingshi.serializable.s2.User;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @date 2022-02-28 20:17
 */
public class Client {
    public static void main(String[] args)throws IOException {
        Socket socket = null;
        socket = new Socket("localhost",8071);

        User user=new User(221,"zhangsan");

        ObjectOutputStream out= new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(user);
        socket.close();
    }
}
