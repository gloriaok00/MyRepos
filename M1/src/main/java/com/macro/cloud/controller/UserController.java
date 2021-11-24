package com.macro.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public Object getCurrentUser() {
        return "user";
    }
}
