package com.example.demo.mianshi.lambda;

/**
 * @author zhangyu
 * @date 2019-08-21 16:28
 */
public class LambdaMain {
    public void show(MyInterf myInterf) {
        System.out.println("1");
        myInterf.test(11);
        System.out.println("2");
    }

    public static void main(String[] args) {
        LambdaMain demo = new LambdaMain();
        demo.show((i) -> System.out.println("函数式接口中的test" + i));
        MyInterf ins = (j) -> System.out.println("lambda是对象");
        System.out.println(ins.getClass());
    }
}
