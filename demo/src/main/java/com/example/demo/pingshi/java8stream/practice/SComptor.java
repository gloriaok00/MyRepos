package com.example.demo.pingshi.java8stream.practice;

import java.util.Comparator;

/**
 * @description
 * @date 2022-03-31 13:03
 */

public class SComptor implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if(!(o1 instanceof SS) || !(o2 instanceof SS)){
           return 1023;
        }
        if(((SS)o1).getA()-((SS)o2).getA()>0){
            return 1;
        }else if(((SS)o1).getA()-((SS)o2).getA()==0){
            return 0;
        }else{
            return -1;
        }
    }
}
