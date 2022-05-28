package com.example.demo.mbs.lianxi.mb2;

import lombok.Data;

@Data
public class Student {

 private int id;
 private String name;     // 姓名
 private String gender;   // 性别
 private String major;    // 专业
 private String grade;    // 年级
 private Teacher supervisor; //指导教师

}
