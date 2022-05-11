package com.example.demo.pingshi.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description 浅拷贝与深拷贝
 * @date 2020-05-01 12:25
 * @date 2022-05-11 18:44
 */

@Data
@AllArgsConstructor
public class Student implements Cloneable {

    private int id;
    private String name;
    private SchoolClass schoolClass;

    @Override
    protected Student clone() throws CloneNotSupportedException {

        //浅拷贝
        //return (Student)super.clone();

        //深拷贝
        SchoolClass schoolClassCopy = new SchoolClass(schoolClass.getId(), schoolClass.getName());
        return new Student(id, name, schoolClassCopy);
    }

    public static void main(String[] args) throws Throwable {
        Student s1 = new Student(1, "zy", new SchoolClass(1, "1班"));
        Student copys1 = s1.clone();
        copys1.setSchoolClass(new SchoolClass(2, "2班"));
        System.out.println(s1);
        System.out.println(copys1);
    }
}
