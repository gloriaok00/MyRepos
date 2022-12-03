package com.example.demo.pingshi.myobj.o1;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description @ToString(callSuper = true)
 * @date 2022/12/4 01:42
 */

@ToString(callSuper = true)
@AllArgsConstructor
public class OSDemoSub extends OSDemo {

    private String name;

    public static void main(String[] args) {
        OSDemoSub sub = new OSDemoSub("zy");
        sub.setId(1);
        System.out.println(sub);

        List<String> list = Arrays.asList("s1", "s2");
        List<String> l1=new ArrayList<>();
        l1.add("s3");
        l1.add("s4");
        System.out.println(l1);
        System.out.println(list);
    }
}
