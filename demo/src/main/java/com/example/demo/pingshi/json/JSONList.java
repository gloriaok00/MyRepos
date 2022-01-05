package com.example.demo.pingshi.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangyu
 * @date 2019-10-28 21:08
 */

@Controller
@RequestMapping(value = "/dd")
public class JSONList {

    //@RequestParam不加也行，
    // 不加时url里的参数名称与controller方法里的名称必须一致。加的话可以给value啥的换名称
    @GetMapping(value = "/json22")
    public String getJson(String p1) {
        System.out.println("pp:" + p1);
        return "index";
    }

    @GetMapping(value = "/json1/{id}")
    public String getJson1(@PathVariable String id) {
        return "index";
    }
}
