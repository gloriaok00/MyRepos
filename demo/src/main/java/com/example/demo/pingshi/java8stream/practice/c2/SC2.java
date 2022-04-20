package com.example.demo.pingshi.java8stream.practice.c2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 随机练习
 * @date 2022-04-20 12:26
 */

public class SC2 {

    List<Person> javaProgrammers = null;

    List<Person> phpProgrammers = null;

    @Before
    public void initData() {
        javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }

    //遍历
    @Test
    public void show() {
        System.out.println("javaProgrammers starts:");
        javaProgrammers.forEach(System.out::println);
        System.out.println("javaProgrammers ends:");
        System.out.println("phpProgrammers starts:");
        phpProgrammers.forEach(System.out::println);
        System.out.println("phpProgrammers ends:");
    }

    //add 5% percent
    @Test
    public void addSalary() {
        System.out.println("add salary javaProgrammers starts:");
        javaProgrammers.forEach(e->{
            System.out.println((e.getSalary() * 1.05));
        });
        System.out.println("add salary javaProgrammers ends:");
    }

    @Test
    public void show2(){
        System.out.println("下面是月薪超过30的PHP程序员:");
        phpProgrammers.stream()
                .filter((e)->e.getSalary()>30)
                .forEach((e) -> System.out.println(e.getFirstName()+" "+e.getLastName()));
    }
}
