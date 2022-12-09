package com.example.demo.pingshi.serializable.s4;

import lombok.Data;

import java.io.Serializable;

/**
 * @description
 * @date 2022/12/9 16:32
 */

@Data
public class Person implements Serializable {

    private String username;
    private transient String password; // transient修饰的变量不再被序列化
    private static String address; // 一个静态变量不管是否被transient修饰，均不能被序列化

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
