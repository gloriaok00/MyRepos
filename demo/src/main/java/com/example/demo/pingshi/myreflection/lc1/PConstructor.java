package com.example.demo.pingshi.myreflection.lc1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description
 * @date 2022-04-30 14:34
 */

public class PConstructor {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       Class xx= Person.class;
       Constructor[] nn=xx.getConstructors();
        for (Constructor con : nn) {
            System.out.println(con.getParameterCount());
        }
        System.out.println();
        Constructor<Person> nameCon=xx.getConstructor(String.class);
        Person nameP=nameCon.newInstance("zy");
        System.out.println(nameP);

    }
}
