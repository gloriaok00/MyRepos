package com.example.demo.pingshi.datatype.mygeneric.g4;

/**
 * @description 泛型定义在方法中
 * @date 2022-04-25 23:46
 */

public class FX4 {

    //定义在方法中的泛型
    public <TTT> void show(TTT ttt){
        System.out.println(ttt);
    }
}
