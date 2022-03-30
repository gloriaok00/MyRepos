package com.example.demo.pingshi.java8stream.mylambda3;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description 学习中 lambda
 * @date 2022-03-30 16:27
 */

public class Lbd3 {

    public static void main(String[] args) {
        // Map.Entry.<Integer, String>comparingByKey()
        //List<SelectCameraViewDTO> returnList = resultMap.entrySet().stream().sorted(Map.Entry.<String, SelectCameraViewDTO>comparingByKey().reversed()).map(e -> new SelectCameraViewDTO(e.getKey(), e.getValue().getWorksiteList())).collect(Collectors.toList());
        List<Person2> pList=new ArrayList();
        Person2 p11=new Person2(1,"1号");
        Person2 p22=new Person2(2,"2号");
        pList.add(p11);
        pList.add(p22);
        //.sorted(Map.Entry.<Integer, Person2>comparingByKey().reversed())
        Map<Integer,Person2> maps=pList.stream().collect(Collectors.toMap(Person2::getId, p2 -> new Person2(p2.getId(),p2.getName())));
        maps.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
            System.out.println("=====");
        });
        List<Integer> ll=pList.stream().map(Person2::getId).collect(Collectors.toList());
        ll.forEach(System.out::println);
    }

}

@Data
@AllArgsConstructor
class Person2{
    private Integer id;
    private String name;
}
