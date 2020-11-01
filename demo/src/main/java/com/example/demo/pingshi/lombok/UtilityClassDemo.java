package com.example.demo.pingshi.lombok;

import lombok.experimental.UtilityClass;

/**
 * @author zhangyu
 * @description @UtilityClass最佳实线  粗浅的理解为所有的属性及方法都是静态的
 * @date 2020-09-23 11:27
 */

@UtilityClass
public class UtilityClassDemo {

    private int CONSTANT = 5;

    public int addSomething(int in) {
        return in + CONSTANT;
    }

    public static void main(String[] args) {
        System.out.println(UtilityClassDemo.CONSTANT);
        System.out.println(UtilityClassDemo.addSomething(7));
    }
}
