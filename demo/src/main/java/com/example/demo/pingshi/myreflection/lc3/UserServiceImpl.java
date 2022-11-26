package com.example.demo.pingshi.myreflection.lc3;

public class UserServiceImpl implements UserService{

    @Override
    public int insert() {
        System.out.println("insert");
        return 0;
    }

    @Override
    public String query() {
        System.out.println("query");
        return null;
    }
}
