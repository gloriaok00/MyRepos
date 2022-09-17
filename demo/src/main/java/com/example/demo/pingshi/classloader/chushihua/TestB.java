package com.example.demo.pingshi.classloader.chushihua;

import lombok.Data;

/**
 * @description
 * @date 2022/9/17 19:45
 */

@Data
public class TestB {

    static {
        System.out.println("这是TestB初始化");
    }

    private int i = 5;
}
