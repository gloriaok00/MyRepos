package com.example.demo.mm.io.select.fuyong;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class SelectorExample {

    public static void main(String[] args) throws Exception {
        // 创建ServerSocketChannel，监听端口9999
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);

        // 创建Selector并将serverSocketChannel注册到selector中，监听accept事件
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started...");

        while (true) {
            // 阻塞，等待IO事件
            selector.select();

            // 处理所有已发生的IO事件
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                // 处理accept事件
                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = serverChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("New client connected: " + clientChannel.getRemoteAddress());
                }

                // 处理read事件
                if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = clientChannel.read(buffer);
                    if (bytesRead == -1) {
                        // 客户端关闭连接
                        System.out.println("Connection closed: " + clientChannel.getRemoteAddress());
                        clientChannel.close();
                    } else {
                        buffer.flip();
                        byte[] data = new byte[bytesRead];
                        buffer.get(data);
                        String message = new String(data).trim();
                        System.out.println("Message received: " + message);
                        Thread.sleep(9000);
                    }
                }

                // 将已处理的事件从selector中移除
                iterator.remove();
            }
        }
    }
}
