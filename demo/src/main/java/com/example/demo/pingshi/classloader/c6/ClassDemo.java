package com.example.demo.pingshi.classloader.c6;

import lombok.SneakyThrows;
import org.junit.Test;

/**
 * @description 激动在看完了Class这个类别的相关知识后 问题迎刃而解
 * @date 2022/10/20 08:54
 * @date 2022/12/02 00:44
 */

public class ClassDemo {

    String className = "com.example.demo.pingshi.classloader.c6.ClassDemo";

    @SneakyThrows
    @Test
    public void gdsg() {
        Class mmzz = ClassDemo.class.getClassLoader().loadClass(className);
        System.out.println(mmzz.getName());
    }


    @SneakyThrows
    @Test
    public void dfsdf() {
        Class mmzz = this.getClass().getClassLoader().loadClass(className);
        System.out.println(mmzz.getName());
    }

}
