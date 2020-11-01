package com.example.demo.pingshi.clone;

import lombok.*;

import java.util.Date;

/**
 * @author zhangyu
 * @description
 * @date 2020-05-01 12:25
 */

@Data
@AllArgsConstructor
public class Student implements Cloneable {

    private int id;
    private String name;
    private Date hireDate;
    private SchoolClass schoolClass;

    @Override
    protected Student clone() throws CloneNotSupportedException {

        //浅拷贝
        //return (Student)super.clone();

        //深拷贝
        //对于SchoolClass也可以实现其Cloneable接口，然后直接用.clone也行
        SchoolClass schoolClassCopy = new SchoolClass(schoolClass.getId(), schoolClass.getName());
        return new Student(id, name, (Date) this.hireDate.clone(), schoolClassCopy);
    }

    public static void main(String[] args) throws Throwable {
        Student s1 = new Student(1, "zy", new Date(2000, 1, 1), new SchoolClass(1, "1班"));
        Student copys1 = s1.clone();
        copys1.setHireDate(new Date(2222, 1, 1));
        copys1.setSchoolClass(new SchoolClass(2, "2班"));
        System.out.println(s1.toString());
        System.out.println(copys1.toString());

    }
}
