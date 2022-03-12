package com.example.demo.pingshi.javamodifier.sub;

import com.example.demo.pingshi.javamodifier.MyModifier;
import org.junit.Test;

/**
 * @description
 * @date 2021-12-02 14:13
 * @date 2022-03-12 13:53
 */

public class ModifierDemo extends MyModifier {

    @Test
    public void show() {
        MyModifier myModifier = new MyModifier();
        System.out.println(myModifier.b);
        System.out.println(myModifier.c);
    }

    @Test
    public void dd(){
        System.out.println(b);
        System.out.println(c);
    }
}
