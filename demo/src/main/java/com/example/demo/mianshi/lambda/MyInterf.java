package com.example.demo.mianshi.lambda;

/**
 * @author zhangyu
 * @date 2019-08-21 15:58
 */

@FunctionalInterface
public interface MyInterf {

    void test(int i);

    @Override
    String toString();

    default void lalalala(int i) {
        System.out.println(i);
    }

}
