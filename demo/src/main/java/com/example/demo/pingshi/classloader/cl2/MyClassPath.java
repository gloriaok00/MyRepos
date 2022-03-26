package com.example.demo.pingshi.classloader.cl2;

import sun.net.spi.nameservice.dns.DNSNameService;

/**
 * @description
 * @date 2022-03-26 21:07
 */

public class MyClassPath {
    public static void main(String[] args) {
        String bootPath = System.getProperty("sun.boot.class.path");
        String extPath= System.getProperty("java.ext.dirs");
        String appPath = System.getProperty("java.class.path");
        System.out.println("bootPath:"+bootPath);
        System.out.println("==============");
        System.out.println("extPath:"+extPath);
        System.out.println("==============");
        System.out.println("appPath:"+appPath);

        System.out.println("ClassLodarDemo's ClasdsLoader is " + MyClassPath.class.getClassLoader());
        System.out.println("ClassLodarDemo's ClasdsLoader ppp is " + MyClassPath.class.getClassLoader().getParent());
        System.out.println("DNSNameService's ClassLoader is " + DNSNameService.class.getClassLoader());
        System.out.println("DNSNameService's ClassLoader is " + DNSNameService.class.getClassLoader());
        System.out.println("String's ClassLoader is " + String.class.getClassLoader());

    }
}
