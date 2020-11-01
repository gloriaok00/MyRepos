package com.example.demo.pingshi.servlet;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;


@Data
@Service
public class BusinessService {

    private List<String> list = null;

    /**
     * 构造方法执行之后，调用此方法
     */
    @PostConstruct
    public void initsdad(){
        System.out.println("在构造方法调完后，会调 @PostConstruct所在的方法");
        System.out.println("初始化一些个东西啥的");
    }

    public BusinessService(){
        System.out.println("这是BusinessService的构造方法");
    }

    /**
     * 在destroy方法之后执行
     */
    @PreDestroy
    public void destroy(){
        System.out.println("销毁bean");

    }
}