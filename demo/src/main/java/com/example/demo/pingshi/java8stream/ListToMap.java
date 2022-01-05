package com.example.demo.pingshi.java8stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyu
 * @date 2019/12/9 11:59
 */
public class ListToMap {
    public static void main(String[] args) {

        //myList.stream().filter(e-> !StringUtils.isEmpty(e)).sorted().distinct().collect(Collectors.toList()).forEach(e-> System.out.println(e));
        //List<Integer> myNumList= Arrays.asList(1,2,3,4,45,56,23,11);
        //myNumList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(e-> System.out.println(e));
        // myNumList.stream().map(e->e*e).collect(Collectors.toList()).forEach(e-> System.out.println(e));
        //myNumList.parallelStream().sorted().collect(Collectors.toList()).forEach(e-> System.out.println(e));
        Student s1 = new Student(1, "zy", 23);
        Student s2 = new Student(2, "kui", 32);
        Student s3 = new Student(3, "yu", 13);
        Student s4 = new Student(3, "yu2", 13);
        List<Student> myList = Arrays.asList(s1, s2, s3, s4);
      /* myList.stream().collect(Collectors.toList()).forEach(e->{
           System.out.println(e.getId() + "-" + e.getName() + "-" + e.getAge());
       });*/
        //myList.stream().map(e->e.getName()).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(e-> System.out.println(e));

        /* Map<Integer,String> myHashMap= myList.stream().collect(Collectors.toMap(Student::getId,Student::getName));
        myHashMap.entrySet().forEach(e->{
            System.out.println(e.getKey() + "-" + e.getValue());
        });*/
        //myList.stream().collect(Collectors.toMap(Student::getId,Student->Student)).entrySet().forEach(e-> System.out.println(e.getKey()+"-"+e.getValue().toString()));
        //这里光把sorted配置了还不行，因为hashMap本来没有顺序，只有最后将含有顺序的放入到一个新的LinkedHashMap中
        myList.stream().sorted(Comparator.comparingInt(Student::getId).reversed()).collect(Collectors.toMap(Student::getId, Student -> Student, (oldValue, newValue) -> newValue, LinkedHashMap::new)).entrySet().forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));
    }

}
