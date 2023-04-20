package com.example.demo.mm.io.select.fuyong;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.connect(new InetSocketAddress("127.0.0.1", 9999));
        for (int i = 0; i <= 10000; i++) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String message = "Hello, Server!";
            buffer.put(message.getBytes());
            buffer.flip();
            channel.write(buffer);
        }
        channel.shutdownOutput();
        channel.close();
    }
}
