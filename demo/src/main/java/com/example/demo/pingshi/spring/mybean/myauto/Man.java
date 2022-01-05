package com.example.demo.pingshi.spring.mybean.myauto;

import org.springframework.stereotype.Service;

@Service
public class Man implements Human {

    public String runMarathon() {
        return "A man run marathon";
    }
}
