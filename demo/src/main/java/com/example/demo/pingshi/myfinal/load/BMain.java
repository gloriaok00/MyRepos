package com.example.demo.pingshi.myfinal.load;

/**
 * @description 遇到new、getstatic、putstatic或invokestatic这4条字节码指令时，如果类没有进行过初始化，则需要先触发其初始化。
 * 生成这4条指令的最常见的Java代码场景是：
 * 使用new关键字实例化对象的时候、读取或设置一个类的静态字段（被final修饰、已在编译期把结果放入常量池的静态字段除外）的时候，以及调用一个类的静态方法的时候。
 * @date 2022/10/17 00:51
 */

public class BMain {

    public static void main(String[] args) {
        //调的常量，没有引起类的初始化
        System.out.println(Book.xx);
        //直接调的static字段，引起了类的初始化
        //System.out.println(Book.xx1);
    }
}
