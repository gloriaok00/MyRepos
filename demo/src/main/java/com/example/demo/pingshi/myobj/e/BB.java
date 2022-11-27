package com.example.demo.pingshi.myobj.e;

/**
 * @description
 * @date 2022/11/27 13:26
 */

public class BB extends AA {

    private String name;

    public BB(int id) {
        super(id);
    }

    public BB(int id, String name) {
        super(id);
        this.name = name;
    }
}
