package com.example.demo.pingshi.innerclass;

/**
 * @description
 * @date 2021-11-12 09:49
 */

public class OuterClass {

    private int a = 1;

    protected void oo() {
        System.out.println("这是受保护的方法");
    }

    protected class InnerClass {
        public void show(String s) {

        }
    }
}

//保留类
class NonPublicClass {
    public void show() {
        System.out.println("这是非公共类");
    }
}
