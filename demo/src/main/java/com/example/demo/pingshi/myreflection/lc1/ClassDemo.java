package com.example.demo.pingshi.myreflection.lc1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description 随机练习
 * @date 2022-04-30 14:21
 */

public class ClassDemo {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取class的三种方式
        //1
        Person p = new Person();
        Class c1 = p.getClass();
        //2
        Class c2 = Person.class;
        //3
        Class c3 = Class.forName("com.example.demo.pingshi.myreflection.lc1.Person");

        //con
        Constructor[] cons = c3.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con.getParameterCount());
        }
        System.out.println();
        Constructor nameCon=c3.getConstructor(String.class);
        Person pName=(Person) nameCon.newInstance("test");
        System.out.println(pName);
    }
}
