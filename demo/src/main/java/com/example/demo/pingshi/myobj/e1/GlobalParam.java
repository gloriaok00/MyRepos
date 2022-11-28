package com.example.demo.pingshi.myobj.e1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2022/11/28 15:43
 */

@RestController
public class GlobalParam {

    public int a = 1;

    @GetMapping("/xx2")
    public void init() {
        a = a + 1;
        System.out.println(a);
    }
}
