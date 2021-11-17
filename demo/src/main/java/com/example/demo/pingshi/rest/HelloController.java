package com.example.demo.pingshi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @description  restcontroller本身这个参数是value，仅仅是
 * 语义上的含义或说明 并不是路径的定义 若用路径的 需要用@RequestMapping
 * @date 2021/11/17 10:41
 */


@RestController("/api")
public class HelloController {

    @GetMapping("/hello")
    //String name
    public String say() {
        return "hi , " + "name";
    }

}
