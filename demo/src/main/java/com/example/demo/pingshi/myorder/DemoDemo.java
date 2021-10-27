package com.example.demo.pingshi.myorder;


import java.util.*;

/**
 * @author zhangyu
 * @description
 * @date 2020-05-02 09:42
 */

public class DemoDemo {
    public static void main(String[] args) {
        String[] strs={"fsdf","2","as","435","mghggfh","4567",};
        Arrays.sort(strs, Comparator.comparingInt(x->x.length()));
        System.out.println(Arrays.toString(strs));

        Student s1=new Student(1,"学生555");
        Student s2=new Student(2,"学生2444");
        Student s4=new Student(null,"学生4333");
        Student s5=new Student(5,"学生52");
        Student s3=new Student(3,"学生3");
        List<Student> studentList=new LinkedList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s3);
        System.out.println(studentList.toString());

        //Collections.sort(studentList,Comparator.comparingInt(x->x.getName().length()));
        Collections.sort(studentList,Comparator.comparing(Student::getId,Comparator.nullsFirst(Comparator.reverseOrder())));
        System.out.println(studentList.toString());

    }
}
