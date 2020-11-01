package com.example.demo.pingshi.webscoket;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 *  Deepglint实时抓拍
 */
@Slf4j
public class Demo extends WebSocketClient {

    private static Demo instance=null;

    public Demo(URI serverUri) {
        super(serverUri);
        this.setConnectionLostTimeout(0);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        send("Hello, it is me. Mario :)");
        log.info("opened connection");
    }

    @Override
    public void onMessage(String message) {
        log.info("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.info("Test Test Connection closed by " + (remote ? "remote peer" : "us") + " Code: " + code + " Reason: " + reason);
        log.info("remote:"+remote);
        log.info("格林web socket连接中断,尝试重连....");
        if (remote) {
            onReconnect();
        }
    }

    public void onReconnect() {
        onCloseWebsocket();
        Runnable reconnection = new Runnable() {
            @Override
            public void run() {
                try {
                    while (!isOpen()) {
                        reconnect();
                        TimeUnit.SECONDS.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(reconnection).start();
    }

    /**
     * 关闭websocket连接
     */
    public void onCloseWebsocket() {
        try {
            this.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    public static Demo init () {

        String host = "webscoket://10.232.3.150:8088";
        String url = host;

        try {
            instance = new Demo(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public void toConnect(){
        if (instance == null) {
            instance=init();
            instance.connect();
        }else{
            instance.connect();
        }
    }
    public static void main(String[] args) {
        Demo.init().toConnect();
    }
}