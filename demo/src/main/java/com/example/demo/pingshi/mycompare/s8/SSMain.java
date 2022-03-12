package com.example.demo.pingshi.mycompare.s8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description stream Comparator
 * @date 2022-03-09 16:52
 */

public class SSMain {

    public static void main(String[] args) {
        //测试数据
        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明",18,1.76));
        studentList.add(new StudentInfo("张小丽",18,1.61));
        studentList.add(new StudentInfo("王大朋",19,1.82));
        studentList.add(new StudentInfo("陈小跑",17,1.67));

        //排序前输出
        System.out.println("排序前输出:");
        studentList.forEach(e->{
            System.out.println(e.toString());
        });

        //按身高排序(身高并没有实现Comparable接口)
        List<StudentInfo> studentsSort = studentList.stream().sorted(Comparator.comparing(StudentInfo::getHeight)).collect(Collectors.toList());
        //List<StudentInfo> studentsSort = studentList.stream().sorted(Comparator.comparingDouble(StudentInfo::getHeight)).collect(Collectors.toList());
        //按年龄排序(年龄实现了Comparable接口)
        //List<StudentInfo> studentsSort = studentList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //排序后输出
        System.out.println("排序后输出:");
        studentsSort.forEach(e->{
            System.out.println(e.toString());
        });
    }
}
