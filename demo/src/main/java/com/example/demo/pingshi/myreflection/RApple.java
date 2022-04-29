package com.example.demo.pingshi.myreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description  java反射初体验
 * @date 2022-04-29 11:32
 */

public class RApple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //正射
        RApple apple = new RApple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //反射
        Class clz = Class.forName("com.example.demo.pingshi.myreflection.RApple");
        Method setPriceMethod = clz.getMethod("setPrice", int.class);
        Constructor appleConstructor = clz.getConstructor();
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }
}
