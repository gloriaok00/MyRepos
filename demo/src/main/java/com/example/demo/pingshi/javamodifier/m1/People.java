package com.example.demo.pingshi.javamodifier.m1;

public class People {

    private String name = null;

    protected String getName() {    //默认访问权限（包访问权限）
        return name;
    }

    protected void setName(String name) {   //默认访问权限（包访问权限）
        this.name = name;
    }

    public  People(){

    }

}
