package com.example.demo.pingshi.myinit.c3;

/**
 *  @description 通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化。
 *  https://juejin.cn/post/6865572557329072141
 *  @date  2022/10/29 13:17
 */

public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
