package com.example.demo.pingshi.myassert;

/**
 * @description 断言学习
 * 屏蔽package 然后正常javac xx，最后java -ea MyAssert
 * https://blog.csdn.net/u010142437/article/details/51388082
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1264740093521088
 * @date 2022-04-21 12:48
 */

public class MyAssert {

    public static void main(String[] args) {
        //String name = "abner chai";
        String name = null;
        assert (name != null);
        System.out.println(name);
    }
}
