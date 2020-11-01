package com.example.demo.pingshi.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangyu
 * @date 2019-10-26 14:34
 */

@Data
public class User implements Serializable {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }
}
