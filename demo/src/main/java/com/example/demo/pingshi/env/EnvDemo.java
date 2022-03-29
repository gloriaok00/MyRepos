package com.example.demo.pingshi.env;

import java.util.Map;

/**
 * @date 2022-03-29 21:48
 */
public class EnvDemo {

    public static void main(String[] args) {
        String env=System.getenv("JAVA_HOME");
        String env1=System.getProperty("java.home");
        System.out.println(env);
        System.out.println(env1);
        Map<String,String> envMap=System.getenv();
        envMap.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
