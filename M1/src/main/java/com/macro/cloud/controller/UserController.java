package com.macro.cloud.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
public class UserController {


    @GetMapping("/user")
    public Object getCurrentUser() {
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        return "user";
    }


    @GetMapping("/test")
    public Object getCurrentTest() {
        return "test";
    }

    @GetMapping("/ddd")
    public Object getDDD() {
        return "ddd";
    }
}
