package com.example.demo.pingshi.mycompare;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description 内部比较器
 * 要求：定义一个学生类，里面有姓名，年龄，成绩三个属性，要求按成绩由高到低排序，如果成绩相等，则按照年龄由低到高排序。
 * @date 2022-03-06 22:50
 */

@AllArgsConstructor
@ToString
public class Student implements Comparable<Student> {

    private String name;
    private int age;
    private float score;

    public static void main(String[] args) {
        Student[] ss={new Student("ZY1",18,99),
                      new Student("ZY22",22,99),
                      new Student("ZY31",21,87),
                      new Student("ZY4",19,100),
                      new Student("ZY5",20,99)};
        //数组排序
       /* Arrays.sort(ss);
        for (Student s : ss) {
            System.out.println(s.toString());
        }*/
        //集合排序
        List<Student> ll= Arrays.asList(ss);
        Collections.sort(ll);
        ll.forEach(l-> System.out.println(l.toString()));
    }

    @Override
    public int compareTo(Student o) {
        if(score>o.score){
           return -1;
        }else if(score==o.score){
            return Integer.compare(age, o.age);
        }else{
            return 1;
        }
    }
}
