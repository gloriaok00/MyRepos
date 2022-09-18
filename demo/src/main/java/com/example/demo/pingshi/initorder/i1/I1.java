package com.example.demo.pingshi.initorder.i1;

/**
 * @description 再研究初始化
 * @date 2022/9/18 20:40
 */
public class I1 {
    static SampleClass sam = new SampleClass("静态成员sam初始化");
    SampleClass sam1 = new SampleClass("普通成员sam1初始化");

    static {
        System.out.println("static块执行");
        if (sam == null) {
            System.out.println("sam is null");
        }
        sam = new SampleClass("静态块内初始化sam成员变量");
    }

    SampleClass sam2 = new SampleClass("普通成员sam2初始化");

    I1() {
        System.out.println("默认构造函数被调用");
    }

    public static void main(String[] args) {
        // 创建第1个主类对象
        System.out.println("第1个主类对象：");
        I1 ts = new I1();

        // 创建第2个主类对象
        System.out.println("第2个主类对象：");
        I1 ts2 = new I1();

        // 查看两个主类对象的静态成员：
        System.out.println("2个主类对象的静态对象：");
        System.out.println("第1个主类对象, 静态成员sam.s: " + ts.sam);
        System.out.println("第2个主类对象, 静态成员sam.s: " + ts2.sam);
    }
}

class SampleClass {

    String s;

    SampleClass(String s) {
        this.s = s;
        System.out.println(s);
    }

    SampleClass() {
        System.out.println("SampleClass默认构造函数被调用");
    }

    @Override
    public String toString() {
        return this.s + "cccc";
    }
}
