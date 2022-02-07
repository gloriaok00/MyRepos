package com.example.demo.pingshi.datatype.fanxing;

/**
 * @description 泛型接口类学习 非实参，类上必须要有泛型
 * @date 2022-02-07 23:20
 */

public class FruitGenerator<TT> implements Generator<TT> {

    @Override
    public TT next() {
        return null;
    }
}
