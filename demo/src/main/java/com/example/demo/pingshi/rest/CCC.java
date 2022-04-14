package com.example.demo.pingshi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2022-01-23 23:57
 */

@RestController
public class CCC {

    private BBB bbb;

    @GetMapping(value = "/xx")
    public void show(){
        bbb.show();
    }

}
