package com.example.demo.pingshi.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangyu
 * @description
 * @date 2020-06-13 17:21
 */

@RestController
@ResponseBody
@Slf4j
public class Restcontroller {

    @GetMapping("/getPerson")
    public Person getPerson(){
        Person p=new Person("zy","23");
        log.info("ddddL:"+p.getName());
        return p;
    }

    @GetMapping("/getPerson11")
    public String getPerson11(){
        Person p=new Person("zy","23");
        return p.toString();
    }

    @PostMapping("/getPerson22")
    public String getPerson11(@RequestBody Person person){
        log.info(person.toString());
        return person.toString();
    }
}
