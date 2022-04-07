package com.example.demo.mianshi.lambda;

/**
 * @author zhangyu
 * @date 2019-08-21 16:28
 * @date 2022-04-06 20:25
 */
public class LambdaMain {
    public void show(MyInterf myInterf) {
        System.out.println("1");
        myInterf.test(11);
        System.out.println("2");
    }

    public static void main(String[] args) {
        LambdaMain demo = new LambdaMain();
        demo.show((i) -> System.out.println("现在学函数式接口，才看懂" + i));
        MyInterf ins = (j) -> System.out.println("这样也行");
        System.out.println(ins.getClass());
    }
}
