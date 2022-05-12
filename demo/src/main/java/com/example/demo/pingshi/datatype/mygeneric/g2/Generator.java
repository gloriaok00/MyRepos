package com.example.demo.pingshi.datatype.mygeneric.g2;

/**
 * @description 泛型接口学习
 * @date 2022-02-07 23:18
 */

//定义一个泛型接口
public interface Generator<TT> {
    void next(TT tt);
}
