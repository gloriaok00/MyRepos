package com.example.demo.mbs.lianxi.mb2;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {

    private int id;
    private String name;          // 教师姓名
    private String gender;        // 教师性别
    private String researchArea;    // 研究领域
    private List<Student> supStudents; // 指导学生

}
