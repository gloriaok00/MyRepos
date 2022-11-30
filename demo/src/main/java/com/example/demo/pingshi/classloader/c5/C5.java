package com.example.demo.pingshi.classloader.c5;

import org.junit.Test;

/**
 * @description 是的获取一个类对象就是这么简单就是直接getClass
 * @date 2022/12/1 00:51
 */

public class C5 {

    @Test
    public void test() {
        C5 c5 = new C5();
        Class c1 = c5.getClass();
        System.out.print("获得的Class对象:");
        System.out.println(c1);
    }
}
