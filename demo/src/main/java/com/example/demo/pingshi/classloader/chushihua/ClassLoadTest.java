package com.example.demo.pingshi.classloader.chushihua;

/**
 *  @description target/class下执行
 *  java -XX:+TraceClassLoading -cp . com.example.demo.pingshi.classloader.c4.ClassLoadTest
 *  @date  2022/9/17 20:11
 */
public class ClassLoadTest {
    public static void main(String args[]) {
        System.out.println("====start A=========");
        Class c1 = TestA.class;
        System.out.println("====end A========");
        System.out.println("====start B=========");
        TestB c2 = new TestB();
        System.out.println("====end B========");

    }
}
