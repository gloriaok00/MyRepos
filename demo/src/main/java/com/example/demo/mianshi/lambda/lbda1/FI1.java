package com.example.demo.mianshi.lambda.lbda1;

/**
 * @author zhangyu 函数式接口也是可以存在静态方法与default方法的
 * @date 2022/4/7 14:57
 */

@FunctionalInterface
public interface FI1 {

    void show();

    default void printData(){
        System.out.println("data");
    }

    default void printData2(){
        System.out.println("data2");
    }

    static void myStM(){
        System.out.println("我是接口中的静态方法");
    }

}
