package com.example.demo.pingshi.spring.mybean.myauto;

import org.springframework.stereotype.Service;

//@Primary
@Service
public class Woman implements Human {

    public String runMarathon() {
        return "An woman run marathon";
    }

}
