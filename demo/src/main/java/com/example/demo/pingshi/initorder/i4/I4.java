package com.example.demo.pingshi.initorder.i4;

/**
 *  @description
 *  构造代码块的作用是给对象进行初始化。对象一建立就运行构造代码块了，而且优先于构造函数执行。
 *  这里要强调一下，有对象建立，才会运行构造代码块，类不能调用构造代码块的，而且构造代码块与构造函数的执行顺序是前者先于后者执行。
 *  构造代码块与构造函数的区别是：构造代码块是给所有对象进行统一初始化，而构造函数是给对应的对象初始化，
 *  因为构造函数是可以多个的，运行哪个构造函数就会建立什么样的对象，但无论建立哪个对象，都会先执行相同的构造代码块。
 *  也就是说，构造代码块中定义的是不同对象共性的初始化内容。
 *  @date  2022/5/15 22:00
 */
public class I4 {

    public I4() {//构造函数
        System.out.println("A的构造函数");
    }

    {//构造代码块
        System.out.println("A的构造代码块");
    }

    static {//静态代码块
        System.out.println("A的静态代码块");
    }

    public static void main(String[] args) {
        //I4 a=new I4();
    }
}
