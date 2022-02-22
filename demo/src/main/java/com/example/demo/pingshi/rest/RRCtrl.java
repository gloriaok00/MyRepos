package com.example.demo.pingshi.rest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author zhangyu
 * @description
 * @date 2020-06-13 17:21
 */

@RestController
@Slf4j
public class RRCtrl {

    //form-data
    @PostMapping("/getPerson")
    public void getPerson(int id, MultipartFile file,String name) {
        System.out.println(id);
        System.out.println(file.getSize());
        System.out.println(file.getName());
        System.out.println(name);
    }

    //x-www-form-urlencoded
    @PostMapping("/getPerson1")
    public void getPerson1(@RequestBody MultiValueMap<String, String> values) {
        System.out.println(values.get("a"));
        System.out.println(values.get("b"));
    }

    //json
    @PostMapping("/getPerson22")
    public String getPerson11(@RequestBody Person person) {
        return person.toString();
    }

    @Data
    class Person1 {
        public String id;
        public String name;
    }
}
