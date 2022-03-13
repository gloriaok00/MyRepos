package com.example.demo.pingshi.innerclass.i2;

import org.junit.Test;

/**
 * @description
 * @date 2022-03-13 00:54
 */

public class MBird {

    @Test
    public void show(){
       Bird bb= new Bird("yellow bird") {
           @Override
           public void fly() {
               System.out.println("yellow bird flying");
           }
       };
        System.out.println(bb.getName());
        bb.fly();
    }

}
