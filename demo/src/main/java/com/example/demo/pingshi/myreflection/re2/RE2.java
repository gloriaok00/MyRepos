package com.example.demo.pingshi.myreflection.re2;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @description
 * @date 2022/12/19 18:41
 */

public class RE2 {

    @SneakyThrows
    public static void main(String[] args) {
        Class clz = Class.forName("com.example.demo.pingshi.myreflection.re2.RE2");
        Method method = clz.getMethod("setPrice", int.class);
        Constructor constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object, 40);
    }

    public void setPrice(int xx) {
        System.out.println("价格是" + xx);
    }
}
