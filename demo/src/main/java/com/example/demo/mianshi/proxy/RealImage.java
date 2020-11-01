package com.example.demo.mianshi.proxy;

/**
 * @author zhangyu
 * @date 2019-09-07 10:59
 */
public class RealImage implements Image {

    @Override
    public void display() {
        System.out.println("i am display from real Image");
    }
}
