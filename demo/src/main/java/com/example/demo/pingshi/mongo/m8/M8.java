package com.example.demo.pingshi.mongo.m8;

import com.example.demo.pingshi.java8stream.Person;
import org.bson.Document;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description 随机练习
 * @date 2022/11/23 14:42
 */

public class M8 {

    public static void main(String[] args) {

        Document d1=new Document();
        d1.put("_id","b547f226-f2fe-4f52-bd32-d698acef7456");
        d1.put("name","1号");

        Document d2=new Document();
        d2.put("_id","e31680ce-cc03-45ea-9415-aa43613d2d59");
        d2.put("name","2号");
        List<Document> l1= Arrays.asList(d1,d2);
        System.out.println("传了参数_id:");
        l1.stream().map(e->e.getString("_id")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("传了参数name:");
        l1.stream().map(e->e.getString("name")).collect(Collectors.toList()).forEach(System.out::println);

        List<String> l2=Arrays.asList("23.23","10.23","90.23","34.9");
        System.out.println("这里传的参数就是泛型里的每一个值,当这种情况时可以省略参数了");
        l2.stream().map(Double::parseDouble).collect(Collectors.toList()).forEach(System.out::println);


        Person p1 = new Person("1号", 1);
        Person p2 = new Person("2号", 2);
        Person p3 = new Person("3号", 3);
        List<Person> l3=Arrays.asList(p1,p2,p3);
        System.out.println("这里是无参数:");
        l3.stream().map(Person::getName).collect(Collectors.toList()).forEach(System.out::println);

    }
}
