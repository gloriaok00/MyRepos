package com.example.demo.pingshi.mqtt.m2;

import com.alibaba.fastjson.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;

/**
 * @description mqtt tls连接学习
 * @date 2022/6/23 10:23
 */

public class MqttTls {

    /**
     * ssl
     */
    public static final String MQTT_BROKER_HOST = "ssl://101.200.135.56:8883";

    /**
     * 订阅标识
     */
    public static final String MQTT_TOPIC = "t2";

    /**
     * 客户端
     */
    public static MqttClient client;

    /**
     * 类加载器
     */
    static final ClassLoader loader = MqttTls.class.getClassLoader();


    public static void main(String... args) throws MqttException {
        // 推送消息
        try {
            client = new MqttClient(MQTT_BROKER_HOST, MqttClient.generateClientId());

            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);

            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            trustStore.setCertificateEntry("Custom CA", CertificateFactory.getInstance("X509").generateCertificate(loader.getResourceAsStream("certs/ca.pem")));

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            TrustManager[] trustManagers = tmf.getTrustManagers();

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManagers, null);
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            //where options is the MqttConnectOptions object
            options.setSocketFactory(sslSocketFactory);
            client.connect(options);

            MqttMessage message = new MqttMessage();
            message.setQos(0);
            JSONObject obj = new JSONObject();
            for (int i = 0; i < 100; i++) {
                obj.put("id", i);
                message.setPayload(JSONObject.toJSONString(obj).getBytes());
                client.publish(MQTT_TOPIC, message);
                System.out.println("msg sent successfully..");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
