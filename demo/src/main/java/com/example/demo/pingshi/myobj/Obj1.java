package com.example.demo.pingshi.myobj;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description
 * @date 2022-04-23 10:49
 */

public class Obj1 {

    public static void main(String[] args) {
        Person p1=new Person(1,"p1");
        Person p2=new Person(1,"p1");
        System.out.println(p1.equals(p2));
    }
}


@AllArgsConstructor
@Data
class Person{
    private int id;
    private String name;
}
