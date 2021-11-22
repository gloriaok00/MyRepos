package org.example.config;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/hello1")
    public String hello1(){
        return "hello1";
    }

    @GetMapping("/hello/hello2")
    public String hello2(){
        return "hello2";
    }

    @PostMapping("/world")
    public String world(){
        return "world";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/home/home1")
    public String home1(){
        return "home1";
    }

    @GetMapping("/home/home2")
    public String home2(){
        return "home2";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
