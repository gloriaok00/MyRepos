package com.example.demo.pingshi.myinit.c1;

/**
 * @description 构造代码块与构造函数的区别是：
 * 构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，
 * 因为构造函数是可以多个的，运行哪个构造函数就会建立什么样的对象，
 * 但无论建立哪个对象，都会先执行相同的构造代码块。
 * 也就是说，构造代码块中定义的是不同对象共性的初始化内容。
 * @date 2022/10/29 12:03
 */

public class CodeDemo {
    public CodeDemo() {
    }

    public CodeDemo(int num) {
        //this();
    }

    {
        System.out.println("construct code  block!");
    }

    public static void main(String[] args) {
        //都不调时 则构造代码块都不执行了 因为没有对象再进行实例化啊 只是这个类在类实例化了
        //无论调了哪个构造函数，都会引起构造代码块的执行
        //CodeDemo dd=new CodeDemo();
        //CodeDemo dd=new CodeDemo(23);
    }
}
