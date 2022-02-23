package com.example.demo.pingshi.json;

import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyu
 * @date 2019-10-28 21:08
 */

@RestController
@RequestMapping(value = "/dd")
public class JSONList {

    //@RequestParam不加也行，
    // 不加时url里的参数名称与controller方法里的名称必须一致。加的话可以给value啥的换名称
    @GetMapping(value = "/json22")
    public String getJson(@RequestParam String name) {
        System.out.println("pp:" + name);
        return "index";
    }

    @GetMapping(value = "/json1/{id}")
    public String getJson1(@PathVariable String id) {
        return "index";
    }
}
