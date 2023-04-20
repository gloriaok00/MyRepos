package com.example.demo.mm.io.select.zhengchang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, read);
                System.out.println("Received message from client: " + message);
                Thread.sleep(8000);
                String response = "Hello, " + message;
                outputStream.write(response.getBytes());
                outputStream.flush();
            }

            socket.close();
            System.out.println("Client disconnected.");
        }
    }

}
