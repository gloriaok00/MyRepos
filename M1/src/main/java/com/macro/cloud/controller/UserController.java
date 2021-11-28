package com.macro.cloud.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by macro on 2019/9/30.
 */
@RestController
public class UserController {

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/user")
    public Object getCurrentUser() {
        return "user";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/test")
    public Object getCurrentTest() {
        return "test";
    }
}
