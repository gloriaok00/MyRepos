package com.example.demo.pingshi.mylist;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @description 泛型擦除
 * @date 2022/11/26 17:13
 */

public class LL2 {

    @Test
    public void xxx() {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
        //只有类上才有.class这个属性 对象上没有
        Class clazz = String.class;
        Class clazz1 = ArrayList.class;
    }

    @Test
    @SneakyThrows
    public void xx2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
