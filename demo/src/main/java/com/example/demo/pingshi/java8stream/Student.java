package com.example.demo.pingshi.java8stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyu
 * @date 2019-11-07 15:03
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student{

    private int id;
    private String name;
    private int age;

    public Student(String name) {
        this.name = name;
    }
}
