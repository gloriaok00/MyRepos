package com.example.demo.pingshi.designpattern.builder.b1;

/**
 * @description 建造者模式再练习
 * @date 2022/12/3 10:56
 */

public class FPM {

    public static void main(String[] args) {
        FilterParam fp = FilterParam.builder().s1("2022-11-16 13:42:39").s6("2022-11-19 20:34:43").build();
        System.out.println(fp.getS1());
        System.out.println(fp.getS6());
        System.out.println("空吧:" + fp.getS2());
    }
}
