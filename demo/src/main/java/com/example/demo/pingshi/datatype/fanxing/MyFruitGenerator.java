package com.example.demo.pingshi.datatype.fanxing;

/**
 * @description 有实参
 * @date 2022-02-07 23:22
 */

public class MyFruitGenerator implements Generator<String> {

    @Override
    public String next() {
        return "当泛型那里是实参时，类上就不用加泛型了";
    }
}
