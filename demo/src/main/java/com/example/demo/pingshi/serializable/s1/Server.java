package com.example.demo.pingshi.serializable.s1;

import com.example.demo.pingshi.serializable.s2.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @date 2022-02-28 20:16
 */
public class Server {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        ServerSocket serverSocket=null;

        serverSocket=new ServerSocket(8071);
        Socket socket = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        User user=(User)objectInputStream.readObject();
        System.out.println(user);
    }
}
