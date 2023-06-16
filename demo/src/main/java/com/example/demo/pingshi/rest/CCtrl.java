package com.example.demo.pingshi.rest;

import com.example.demo.pingshi.bean.BBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 通过@bean注册的
 * @date 2022-01-23 23:57
 * @date 2022-05-31 14:41
 */

@RestController
@RequestMapping("/ctrl")
public class CCtrl {

    @Autowired
    private BBean bBean;

    @GetMapping(value = "/ct")
    public void show() {
        bBean.show();
    }

    @GetMapping(value = "/show")
    public String ss() {
        System.out.println("show");
        return "show-result";
    }

}
