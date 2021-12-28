package com.example.demo.pingshi.java8stream.mylambda;

/**
 * @description
 * @date 2021-12-28 09:46
 */

public class Bird3 implements BirdService{

    @Override
    public int fly(int start, int end) {
        return start*end;
    }
}
