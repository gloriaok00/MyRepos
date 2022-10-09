package com.example.demo.pingshi.box;

import org.junit.Test;

/**
 * @description
 * @date 2022/10/9 13:21
 */

public class MyBox2 {

    @Test
    public void nn(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
    }
}
