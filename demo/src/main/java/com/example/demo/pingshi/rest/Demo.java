package com.example.demo.pingshi.rest;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author zhangyu
 * @date 2019/12/1 15:13
 */
@RestController
public class Demo {

    /**
     * 方法 1 使用 HttpServletRequest 接收
     * */
    @RequestMapping("/demo")
    public String getParam(HttpServletRequest request) {
        System.out.println("啊1");
        System.out.println(request);
        System.out.println(request.getParameter("userName"));
        System.out.println("test");
        //return request.getParameter("userName");
        HttpServletRequest req = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String ip= ServletUtil.getClientIP(req);
        return ip;
    }

    /**
     * 方法 2 使用 RequestParam 接收
     * */
    @RequestMapping("/demo2")
    public String getParam2(@RequestParam(value = "userName") String userName) {
        return userName;
    }

    /**
     * 方法 3 与 方法 2 相同，只是变量名相同可以简化书写
     * */
    @RequestMapping("/demo3")
    public String getParam3(String userName) {
        return userName;
    }

    @RequestMapping("/demo4/{userName}")
    public String getParam4(@PathVariable String userName) {
        return userName;
    }

}
