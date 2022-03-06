package com.example.demo.pingshi.mycompare;

import java.util.Comparator;

/**
 * @description 外部比较器
 * @date 2022-03-06 22:56
 */

public class LengthComparetor implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if(o1.length()-o2.length()>0){
            return 1;
        }else if(o1.length()-o2.length()==0){
            return 0;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        String s1="dsfdsf";
        String s2="nm";
        LengthComparetor com=new LengthComparetor();
        System.out.println(com.compare(s1, s2));
    }
}
