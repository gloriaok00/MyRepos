package com.example.demo.pingshi.classloader.chushihua;

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
