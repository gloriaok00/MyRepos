package com.example.demo.pingshi.innerclass;

/**
 * @description
 * @date 2021-11-12 10:36
 */

public class OC {
    private int aa=2;
    private static int bb=3;
    protected class IC{
        public int aa=1;

        public void show(){
            //内部类可以直接访问外部的任何变量
            System.out.println("内部类访问的外部的静态变量:"+bb);
            //外部与内部类里含有同名的变量
            System.out.println("默认的直接访问内部类的私有变量:"+aa);
            System.out.println("如果访问的外部的变量需要:"+OC.this.aa);
        }
    }

    public static void main(String[] args) {
      OC oc=new OC();
      OC.IC ic=oc.new IC();
      ic.show();
    }
}
