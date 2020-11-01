package com.example.demo.pingshi.servlet;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserMockService {

    public List<String> getUser(){

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        return list;
    }

    public UserMockService() {
        System.out.println("这是UserMockService的构造方法");
    }

    /**
     * 构造方法执行之后，调用此方法
     */
    @PostConstruct
    public void initddddd(){
        System.out.println("构造方法执行之后，调用此方法");
        System.out.println("做个初始化啥的业务");
    }
}