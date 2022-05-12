package com.example.demo.pingshi.datatype.mygeneric.g2;

/**
 * @description Generator是实参了，MyFruitGenerator就可以不加泛型了
 * @date 2022-02-07 23:22
 */

public class MyFruitGenerator implements Generator<String> {

    @Override
    public void next(String s) {
        System.out.println(s);
    }
}
