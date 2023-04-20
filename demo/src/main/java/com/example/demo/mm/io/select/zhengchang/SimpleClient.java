package com.example.demo.mm.io.select.zhengchang;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server.");

        for (int i = 0; i <= 1000; i++) {
           /* if (i % 5 ==0) {
                Thread.sleep(9000);
            }*/
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String message = "world";
            outputStream.write(message.getBytes());
            outputStream.flush();

            byte[] buffer = new byte[1024];
            int read = inputStream.read(buffer);
            String response = new String(buffer, 0, read);

            System.out.println("Received response from server: " + response);
        }

        socket.close();
    }

}
