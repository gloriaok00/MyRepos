package com.example.demo.mianshi.cas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zhangyu
 * @date 2019-09-09 14:44
 */
public class MyAtomicReference {

    public static void main(String[] args) {
        /**
         * 这个就是关于对象类型的
         */
        AtomicReference<User> atomicReference = new AtomicReference<User>();
        User u1 = new User("kui", 23);
        User u2 = new User("gg", 26);
        atomicReference.set(u1);
        System.out.println(atomicReference.compareAndSet(u1, u2) + "\t" + atomicReference.get().getName());

        Collections.synchronizedList(new ArrayList<>());
    }
}
