package com.example.demo.pingshi.initorder;

import com.example.demo.pingshi.innerclass.OC;
import com.example.demo.pingshi.innerclass.OuterClass;

/**
 * @description
 * @date 2021-11-12 10:00
 */

public class SubOuter extends OuterClass{

    public void show(){
        OC oc=new OC();
        //无法实例化OC的成员内部类，因为没有继承也不在同包
        //oc.ic
    }
    public static void main(String[] args) {
       /* 这里subOuter本身是OuterClass的子类，虽然他们不再同一个包，
        但由于有继承关系，所以依旧可以访问到*/
        SubOuter so=new SubOuter();
        so.oo();
        OuterClass oc=new OuterClass();
        //oc自己的方法，自己访问不了，由于不再本类中，也不是public修饰的
        //oc.oc();
    }
}
