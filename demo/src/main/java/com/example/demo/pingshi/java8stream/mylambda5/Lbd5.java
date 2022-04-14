package com.example.demo.pingshi.java8stream.mylambda5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @description 随机练习
 * @date 2022-04-15 00:10
 */

public class Lbd5 {

    public static void main(String[] args) {
        String[] arr={"a","b","c"};
        List<String> list= Arrays.asList(arr);
        String[] xxx=(String[])list.toArray();
        for (String s : xxx) {
            System.out.println(s);
        }
        Function<String,Person> ff=Person::new;
        Person pp=ff.apply("zy");
        System.out.println(pp.getName());

    }
}

@AllArgsConstructor
@Data
class Person{
    private String name;
}
