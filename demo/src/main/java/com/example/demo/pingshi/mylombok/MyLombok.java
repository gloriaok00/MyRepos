package com.example.demo.pingshi.mylombok;

import org.junit.Test;

/**
 * @description
 * @date 2021-12-02 09:49
 */

public class MyLombok {

    @Test
    public void initPerson(){
        Person p=new Person.Builder(12).id(1023).name("zy").age(34).build();
        System.out.println(p.getId());
        System.out.println(p.getName());
        System.out.println(p.getAge());

        Student1 s1=Student1.builder().build();
        System.out.println(s1.getAge());
    }
}
