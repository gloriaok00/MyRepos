package com.example.demo.pingshi.myreflection.re2;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description
 * @date 2022/12/19 18:41
 */

public class RE2 {

    int price;
    String name;

    @SneakyThrows
    public static void main(String[] args) {
        Class clz = Class.forName("com.example.demo.pingshi.myreflection.re2.RE2");
        Method method = clz.getMethod("setPrice", int.class);
        Method method1 = clz.getMethod("setName", String.class);
        Method method2 = clz.getMethod("getName", null);
        Method method3 = clz.getMethod("getPrice", null);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object, 40);
        method1.invoke(object, "怪物史莱克");
        method2.invoke(object, null);
        method3.invoke(object, null);
    }

    public void setPrice(int xx) {
        System.out.println("价格是" + xx);
        this.price = xx;
    }

    public void getPrice() {
        System.out.println("当前的价格是" + price);
    }

    public void setName(String xx) {
        System.out.println("书名是" + xx);
        this.name = xx;
    }

    public void getName() {
        System.out.println("当前的书本是" + name);
    }

}
