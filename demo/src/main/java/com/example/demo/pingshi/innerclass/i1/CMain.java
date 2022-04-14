package com.example.demo.pingshi.innerclass.i1;

import org.junit.Test;

/**
 * @description
 * @date 2022-03-16 09:08
 */

public class CMain {

    @Test
    public void show(){
        Circle c=new Circle();
        Circle.Draw cc=c.new Draw();
        cc.printData();
    }

    public static void main(String[] args) {
        Circle c=new Circle();
        Circle.Draw cc=c.new Draw();
        cc.printData();
    }
}
