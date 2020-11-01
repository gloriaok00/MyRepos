package com.example.demo.pingshi.servlet;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * value就是bean的id，默认不写时就是类名的首字母小写。其它包括@Component都是一样的
 */
//这里用与BeanService一样的名字就会报错嘛，因为应用中存在两个一样id的bean
//@Service(value = "beanService")
@Service(value = "beanService1")
public class BeanService1 {

    public List<String> getUser(){

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        return list;
    }
}