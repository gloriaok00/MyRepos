package com.example.demo.pingshi.enumpractise;

/**
 * @author zhangyu
 * @date 2019-10-26 21:53
 */
public class EnumDemo {

    public static void main(String[] args) {
        //System.out.println(EnumWeek.Monday.name());
        for (EnumWeek value : EnumWeek.values()) {
            //System.out.println(value);
            System.out.println(value.getName());
            System.out.println(value.getCode());
        }
    }
}
