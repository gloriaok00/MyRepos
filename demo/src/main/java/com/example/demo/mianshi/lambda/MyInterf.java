package com.example.demo.mianshi.lambda;

/**
 * @author zhangyu
 * @date 2019-08-21 15:58
 */

@FunctionalInterface
public interface MyInterf {

    void test(int i);

    //函数式接口里是可以包含Object里的public方法的
    //https://blog.csdn.net/sl1992/article/details/81750599
    @Override
    String toString();

    default void lalalala(int i) {
        System.out.println(i);
    }

}
