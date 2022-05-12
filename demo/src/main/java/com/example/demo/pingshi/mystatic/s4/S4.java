package com.example.demo.pingshi.mystatic.s4;

public class S4 {

    private static int a;
    private int b;

    static {
        S4.a = 3;
        System.out.println(a);
        S4 t = new S4();
        t.f();
        t.b = 1000;
        System.out.println(t.b);
    }

    static {
        S4.a = 4;
        System.out.println(a);
    }

    public static void main(String[] args) {

    }

    static {
        S4.a = 5;
        System.out.println(a);
    }

    public void f() {
        System.out.println("hhahhahah");
    }

    public S4(){
        System.out.println("S4构造器完成");
    }
}
