package com.example.demo.pingshi.innerclass;

/**
 * @description
 * @date 2021-11-12 10:56
 */

public class OO {

    private int a = 1;
    private static int b = 2;

    static class innerStatic {
        public void show() {
            //成员静态内部类无法访问外部类的非静态变量
            //System.out.println(a);
            System.out.println(b);
        }

        ;
    }

    public static void main(String[] args) {
        OC oc = new OC();
        OC.IC ic = oc.new IC();
    }

    public Person1 Woman() {
        class PartClass extends Person1 {
            private int a = 1;
        }
        return new PartClass();
    }
}

class Person1 {

}
