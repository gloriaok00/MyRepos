package com.example.demo.pingshi.myexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {

    @GetMapping("/exp")
    public Object testException() {
        throw new CustomerException("14000001", "String[] strs's length < 4");
        //throw new IndexOutOfBoundsException();
    }
}
