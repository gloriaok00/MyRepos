package com.example.demo.pingshi.innerclass.i1;

/**
 * @description
 * @date 2022-03-12 11:58
 */

public class Circle {

    private float weight = 12.34f;
    public static int len = 8;

    class Draw {

        public void printData() {
            System.out.println(weight);
            System.out.println(len);
        }

    }

}
