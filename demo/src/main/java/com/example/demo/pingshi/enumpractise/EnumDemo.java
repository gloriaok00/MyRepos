package com.example.demo.pingshi.enumpractise;

/**
 * @author zhangyu
 * @description 枚举基础
 * @date 2022-02-25 11:02
 */

public class EnumDemo {
    public static void main(String[] args) {
        for (EnumWeek week:EnumWeek.values()){
            System.out.println("我的索引:"+week.ordinal()+" 我的CODE:"+week.getCode() + " 我的名称:"+week.getName());
        }
        System.out.println(EnumWeek.valueOf("Monday"));

        //枚举类型的equals方法，由于枚举是单例，所以即使equals里是==也返回true
        EnumWeek m1=EnumWeek.Monday;
        EnumWeek m2=EnumWeek.Monday;
        System.out.println(m1.equals(m2));
    }
}
