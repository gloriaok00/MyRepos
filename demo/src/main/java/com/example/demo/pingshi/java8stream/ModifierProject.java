package com.example.demo.pingshi.java8stream;

import com.example.demo.pingshi.javamodifier.MyPrivate;

/**
 * @description MyPrivate中的a是protected的，
 * 由于在不同包里，通过继承，这样也能拿到a
 * @date 2021-11-09 15:31
 */

public class ModifierProject extends MyPrivate {

    public static void main(String[] args) {
        //MyPrivate xx=new MyPrivate(); 若实例化成MyPrivate, a那里是编译不过去的
        ModifierProject xx = new ModifierProject();
        System.out.println(xx.a);
    }
}
