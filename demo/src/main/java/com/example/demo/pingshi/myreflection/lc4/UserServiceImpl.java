package com.example.demo.pingshi.myreflection.lc4;

import com.example.demo.pingshi.myreflection.lc3.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int insert() {
        System.out.println("insert");
        query();
        return 0;
    }

    @Override
    public String query() {
        System.out.println("query");
        return null;
    }
}
