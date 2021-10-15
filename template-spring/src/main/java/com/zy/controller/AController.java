package com.zy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyu
 * @description
 * @date 2021-10-14 15:42
 */

@RestController
public class AController {

    @GetMapping("/abc")
    public String A(){
        return "A";
    }
}
