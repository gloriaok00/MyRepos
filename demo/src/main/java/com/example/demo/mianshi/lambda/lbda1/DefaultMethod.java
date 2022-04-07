package com.example.demo.mianshi.lambda.lbda1;

public interface DefaultMethod {

    //函数式接口可以存在多个default方法，只要保证抽象的方法只有一个就好
    default void defaultVoidMethod() {

    }

    default String sayHello(String name) {
        return String.format("%s say hello!", name);
    }

    //函数式接口里可以存在静态方法
    static void main(String[] args) throws Exception {
        //内部类
        class Impl implements DefaultMethod {

        }
        DefaultMethod defaultMethod = new Impl();
        System.out.println(defaultMethod.sayHello("thinkwon"));
    }
}
