package com.example.demo.mianshi.lambda.p1;

/**
 * @description
 * @date 2022-04-07 11:12
 */

public class MNoParamFi {

    public static void main(String[] args) {
        //lambda可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号
        NoParamFI<String> noParamFI= System.out::println;
        noParamFI.showAnything("对抗寂寞");
    }
}
