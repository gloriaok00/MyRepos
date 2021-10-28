package com.example.demo.pingshi.classloader;

/**
 * @description
 * @date 2021-10-28 21:18
 */

public class MyClassPath {
    public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");
        for (String path : classPath.split(";")) {

            System.out.println(path);
        }
        //System.out.println(ClassLoader.getSystemClassLoader());
    }
}
