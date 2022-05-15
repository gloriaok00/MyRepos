package com.example.demo.pingshi.initorder.i4;

class Base {

    public Base() {
        System.out.println("父类构造方法");
    }

    String b = "父类非静态变量";
    {
        System.out.println(b);
        System.out.println("父类非静态代码块");
    }

    static String a = "父类静态变量";

    static {
        System.out.println(a);
        System.out.println("父类静态代码块");
    }

    public static void A() {
        System.out.println("父类普通静态方法");
    }

}

class Derived extends Base {

    public Derived() {
        System.out.println("子类构造器");
    }

    String b = "子类非静态变量";
    {
        System.out.println(b);
        System.out.println("子类非静态代码块");
    }

    static String a = "子类静态变量";

    static {
        System.out.println(a);
        System.out.println("子类静态块");
    }

    public static void A() {
        System.out.println("子类普通静态方法");
    }

    public static void main(String[] args) {
        Base.A();
        Derived.A();
        new Derived();
    }
}
