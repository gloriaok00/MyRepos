package com.example.demo.pingshi.javamodifier;

import org.junit.Test;

/**
 * @description
 * @date 2021-12-02 14:13
 */

public class MyPrivateSub extends MyPrivate {

    @Test
    public void show() {
        MyPrivateSub myPrivateSub = new MyPrivateSub();
        System.out.println(myPrivateSub.s);
    }
}
