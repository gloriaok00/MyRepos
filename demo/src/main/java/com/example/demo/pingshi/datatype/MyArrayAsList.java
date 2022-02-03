package com.example.demo.pingshi.datatype;

import com.example.demo.pingshi.java8stream.Person;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description 泛型必须是引用类型 引用类型的数组没问题 基本类型的直接变成数组了
 * https://blog.csdn.net/qq_15592789/article/details/116710051
 * @date 2022-02-03 23:43
 */

public class MyArrayAsList {

    public static void main(String[] args) {
        int[] zz=new int[3];
        List mm= Arrays.asList(zz);
        System.out.println(mm.get(0));
        int[] cc=(int[]) mm.get(0);
        System.out.println(cc.length);

        Person[] pp=new Person[3];
        Person p1=new Person("1",1);
        Person p2=new Person("2",2);
        Person p3=new Person("3",3);
        pp[0]=p1;
        pp[1]=p2;
        pp[2]=p3;
        List oo=Arrays.asList(pp);
        System.out.println(oo.get(0));

        boolean[] ww=new boolean[3];
        ww[0]=true;
        ww[1]=false;
        ww[2]=true;
        List vv=Arrays.asList(ww);
        System.out.println(vv.get(0));

        //由Arrays.asList得来的list无法add以及remove，是固定的
        //vv.add(1023);
        //vv.remove(0);
        List<Person> list = new LinkedList<Person>(oo);
        list.remove(1);
        list.forEach(e->{
            System.out.println(e);
        });

    }
}
