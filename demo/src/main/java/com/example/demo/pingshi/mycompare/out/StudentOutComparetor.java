package com.example.demo.pingshi.mycompare.out;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description 外部比较器再练习
 * @date 2022-03-12 14:32
 */

public class StudentOutComparetor implements Comparator<StudentOut> {

    @Override
    public int compare(StudentOut s1, StudentOut s2) {
       return Integer.compare(s1.getAge(),s2.getAge());
    }

    public static void main(String[] args) {
        StudentOutComparetor com=new StudentOutComparetor();
        StudentOut s1=new StudentOut("a1",12,38.1f);
        StudentOut s2=new StudentOut("a2",56,89.2f);
        StudentOut s3=new StudentOut("a3",34,55.2f);
        StudentOut[] arr= {s1,s2,s3};
        for (StudentOut studentOut : arr) {
            System.out.println(studentOut.toString());
        }
        System.out.println("===");
        Arrays.sort(arr,com);
        for (StudentOut studentOut : arr) {
            System.out.println(studentOut.toString());
        }
    }
}
