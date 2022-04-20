package com.example.demo.pingshi.java8stream.practice.c2;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
        javaProgrammers.forEach(e -> {
            System.out.println((e.getSalary() * 1.05));
        });
        System.out.println("add salary javaProgrammers ends:");
    }

    @Test
    public void show2() {
        System.out.println("下面是月薪超过1400的PHP程序员:");
        phpProgrammers.stream()
                .filter((e) -> e.getSalary() > 1400)
                .limit(3)
                .forEach((e) -> System.out.println(e.getFirstName() + " " + e.getLastName()));
    }

    @Test
    public void show3() {
        System.out.println("计算付给 Java programmers 的所有money:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(Person::getAge)
                .sum(); //sum
        System.out.println(totalSalary);
    }

    @Test
    public void show4() {
        //计算 count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());
    }

    //flatMap
    @Test
    public void show5() {
        List<String> list = new ArrayList<>();
        list.add("aaa bbb ccc");
        list.add("ddd eee fff");
        list.add("ggg hhh iii");

        list = list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).collect(toList());
        list.forEach(System.out::println);
    }


    @Test
    public void show6() {
        //anyMatch
        System.out.println(javaProgrammers.stream().anyMatch(person -> person.getAge() == 30));
        //findFirst
        System.out.println(javaProgrammers.stream().findFirst());
        //distinct
        javaProgrammers.add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
        List<Person> distinctedList = javaProgrammers.stream().distinct().collect(Collectors.toList());
        distinctedList.forEach(System.out::println);
        //reduce
        System.out.println(distinctedList.stream().map(Person::getAge).reduce(0, Integer::sum));

    }

    @Test
    public void shoow7() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    public void sortStream() {
        Stream<Integer> sortedStream = Stream.of(1, 3, 7, 4, 5, 8, 6, 2).sorted();
        sortedStream.collect(Collectors.toList()).forEach(x -> System.out.print(x + " "));
    }


}
