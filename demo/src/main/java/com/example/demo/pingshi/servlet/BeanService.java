package com.example.demo.pingshi.servlet;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("beanService")
public class BeanService {

    public List<String> getUser(){

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        return list;
    }
}