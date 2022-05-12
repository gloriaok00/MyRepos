package com.example.demo.pingshi.datatype.mygeneric.g3;

import com.example.demo.pingshi.datatype.mygeneric.g2.Generator;
import lombok.extern.slf4j.Slf4j;

/**
 * @description
 * @date 2022-03-31 11:23
 */

@Slf4j
public class NumberGen implements Generator<Number> {

    @Override
    public void next(Number number) {
        log.info(number.toString());
    }

    public static void main(String[] args) {
        NumberGen gInteger = new NumberGen();
        //无法编译
        //gInteger.next("123");
        gInteger.next(123);
    }
}
