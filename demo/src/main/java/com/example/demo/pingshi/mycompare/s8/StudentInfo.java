package com.example.demo.pingshi.mycompare.s8;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentInfo implements Comparable<StudentInfo> {

    //名称
    private String name;

    //年龄
    private Integer age;

    //身高
    private Double height;

    @Override
    public int compareTo(StudentInfo ob) {
        return this.age.compareTo(ob.getAge());
    }

}
