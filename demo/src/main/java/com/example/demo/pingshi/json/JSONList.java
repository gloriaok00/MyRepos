package com.example.demo.pingshi.json;

import com.example.demo.pingshi.rest.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyu
 * @date 2019-10-28 21:08
 */

@Controller
@RequestMapping(value = "/dd")
public class JSONList {

    @GetMapping(value="/json22")
    public Person getJson(@RequestParam String pp) {
        Person p1=new Person();
        p1.setAge("23");
        p1.setName(pp);
        //没有相应页面报错
        return p1;
    }

    @GetMapping(value="/json1/{id}")
    public String getJson1(@PathVariable String id) {
       return "index";
    }
}
