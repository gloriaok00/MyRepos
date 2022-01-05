package com.example.demo.mianshi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyu
 * @date 2019-08-20 17:43
 */

@RestController
@RequestMapping("/rest")
@Slf4j
public class RestDemo {

    @RequestMapping(value = "/getReq")
    public String getReq(@RequestBody User u) {
        System.out.println("ddd");
        System.out.println("dsssss");
        return u.getId() + u.getName();
    }

    @GetMapping("/test/ajax")
    public String testAjax() {
        return "成功";
    }
}
