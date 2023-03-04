package com.example.demo.mm.designpattern;

/**
 * @description 饿汉模式
 * @date 2023/3/4 10:58
 */

public class InsDemo2 {

    private static final InsDemo2 instance = new InsDemo2();

    private InsDemo2() {
    }

    public static InsDemo2 getInstance() {
        return instance;
    }

}
