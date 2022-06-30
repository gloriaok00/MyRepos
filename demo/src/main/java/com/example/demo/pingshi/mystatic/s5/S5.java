package com.example.demo.pingshi.mystatic.s5;

/**
 * @description 对象不能直接调静态方法吗
 * @date 2022/6/30 23:41
 */

public class S5 {

    public static void main(String[] args) {
       S5.xx();
       //也可以通过对象去调静态方法
        S5 s5=new S5();
        s5.xx();
    }

    public static void xx(){
        System.out.println("我是测试");
    }
}
