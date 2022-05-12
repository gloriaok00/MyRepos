package com.example.demo.pingshi.mystatic.s1;

public class S1 extends Base{

    static{
        System.out.println("Sub static");
    }

    public S1(){
        System.out.println("S1 constructor");
    }

    public static void main(String[] args) {
        new S1();
    }
}

class Base{

    static{
        System.out.println("base static");
    }

    public Base(){
        System.out.println("base constructor");
    }
}
