package com.example.demo.pingshi.mycompare.mythan;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description thenComparing学习
 * @date 2022-04-08 16:02
 */

public class MyThanComparator {

    public static void main(String[] args) {
        Person [] persons = new Person[]{
                new Person(22,"zhangsan"),
                new Person(23,"lisi"),
                new Person(23,"wangwu"),
                new Person(22,"wangwu"),
                new Person(22,"lisi"),
                new Person(23,"zhangsan")
        };
        Comparator<Person> comparator = Comparator.comparingInt(x -> x.getName().length());
        Arrays.sort(persons,comparator);
        System.out.println("只排name:");
        System.out.println(JSON.toJSONString(persons));
        comparator = comparator.thenComparingInt(Person::getAge);
        Arrays.sort(persons,comparator);
        System.out.println("再排name的基础上再排age:");
        System.out.println(JSON.toJSONString(persons));
    }
}

@Data
@AllArgsConstructor
class Person{
    private int age;
    private String name;
}
