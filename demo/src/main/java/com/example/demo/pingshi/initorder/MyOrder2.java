package com.example.demo.pingshi.initorder;

/**
 * @description 对于调父类构造器又有了新认识
 * @date 2022/5/12 16:14
 * @date 2022/09/19 13:26
 */
public class MyOrder2 {
    public static void main(String[] args) {
        new Child("param");
    }
}

class Parent {
    static {
        System.out.println("执行父类静态代码块");
    }

    {
        System.out.println("执行父类构造代码块");
    }

    Parent() {
        System.out.println("执行父类无参数构造方法");
    }

    Parent(String str) {
        System.out.println("执行父类带参数构造方法，参数：" + str);
    }

}

class Child extends Parent {
    static {
        System.out.println("执行子类静态代码块");
    }

    {
        System.out.println("执行子类构造代码块");
    }

    Child() {
        System.out.println("执行子类无参数构造方法");
    }

    Child(String str) {
        //没有指定默认调了父类的无参构造器
        //super(str);
        System.out.println("执行子类带参数构造方法，参数" + str);
    }

}
