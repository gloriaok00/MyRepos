package com.example.demo.pingshi.java8stream.practice;

import lombok.Data;

/**
 * @description
 * @date 2022-03-31 12:53
 */

@Data
public class SS implements Comparable{

    private Integer a;
    private String b;
    private Integer c;

    @Override
    public int compareTo(Object o) {
        if(o instanceof SS){
         return   Integer.compare(this.a,((SS) o).a);
        }else{
            return 1023;
        }
    }

    public SS(Integer a, String b) {
        this.a = a;
        this.b = b;
    }

    public SS(Integer a, String b,Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
