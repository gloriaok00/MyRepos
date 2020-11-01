package com.example.demo.mianshi.proxy;

/**
 * @author zhangyu
 * @date 2019-09-07 11:01
 */
public class ProxyImage implements Image {

    private RealImage realImage;

    @Override
    public void display() {
        if (realImage==null){
            realImage=new RealImage();
        }
        System.out.println("dfdsf");
        realImage.display();
        System.out.println("dfsdfdsfdsf");

    }
}
