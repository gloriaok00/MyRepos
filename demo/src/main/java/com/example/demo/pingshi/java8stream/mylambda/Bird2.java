package com.example.demo.pingshi.java8stream.mylambda;

import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2021-12-28 09:30
 */

@Component
public class Bird2 implements BirdService{

    @Override
    public int fly(int start, int end) {
        return start+end;
    }
}
