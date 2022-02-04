package com.example.demo.pingshi.datatype;

import java.util.ArrayList;

/**
 * @description 删除数组 隐喻:数组删除不允许有洞存在
 * @date 2022-02-03 14:02
 */

public class MyArray {

    public static void main(String[] args) {
        //方法1
        MyArray demo=new MyArray();
        //demo.m1();

        //方法2
        demo.m2();
    }

    public void m1(){
        int oldL=10;
        int[] a1=new int[oldL];
        a1[0]=1;
        a1[1]=2;
        a1[2]=3;
        a1[3]=4;
        a1[4]=5;
        a1[5]=6;
        a1[6]=7;
        a1[7]=8;
        //a1[8]=9;
        a1[9]=10;
        System.out.println("原数组:");
        for (int i : a1) {
            System.out.println(i);
        }
        int newL=oldL-1;
        int[] a2=new int[newL];
        int delI=4;
        for (int i = 0; i < a2.length; i++) {
            if(i<delI){
                a2[i]=a1[i];
            }else{
                a2[i]=a1[i+1];
            }
        }
        System.out.println("新数组:");
        for (int i : a2) {
            System.out.println(i);
        }
    }

    public void m2(){
        ArrayList<Integer> zz=new ArrayList<>();
        zz.add(1);
        zz.add(2);
        zz.add(3);
        zz.add(4);
        zz.add(5);
        zz.add(6);
        zz.add(7);
        zz.add(8);
        zz.add(9);
        zz.add(10);
        int delI=4;
        zz.remove(delI);
        System.out.println("新数组:");
        zz.forEach(e-> System.out.println(e));
    }

}
