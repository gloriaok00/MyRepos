package com.example.demo.pingshi.io.o4;

import java.io.IOException;
import java.net.*;

/**
 *  @description udp简单了解
 *  @date  2022/12/14 15:27
 */
public class UDPClient {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] arr = "xxx".getBytes();
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    DatagramSocket datagramSocket = new DatagramSocket();
                    DatagramPacket datagramPacket = new DatagramPacket(arr, arr.length, inetAddress, 1234);
                    datagramSocket.send(datagramPacket);
                    System.out.println("消息已发送");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
