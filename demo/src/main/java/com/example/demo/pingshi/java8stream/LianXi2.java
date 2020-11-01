package com.example.demo.pingshi.java8stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019/12/11 09:41
 */
public class LianXi2 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("jack", 20));
        list.add(new Person("rose", 10));
        list.add(new Person("lucy", 15));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));
        list.add(new Person("tom", 30));
        list.add(new Person("tom", 30));

        //list.stream().map(Person::getName).collect(Collectors.toList()).forEach(e-> System.out.println(e));
        //list.stream().filter(Person->Person.getAge()==20).map(Person::getName).collect(Collectors.toList()).forEach(e-> System.out.println(e));
        //list.stream().distinct().collect(Collectors.toList()).forEach(e-> System.out.println(e));
        list.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList()).forEach(e-> System.out.println(e));





    }
}
