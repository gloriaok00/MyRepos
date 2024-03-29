package com.example.demo.pingshi.rest;

import cn.hutool.extra.servlet.ServletUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 *  @description url以及form-data上的不通过@RequestParam也能接收，就正常就能接收。
 *  然后@RequestBody就是接收raw里的，无论什么格式
 *  @date 2019/12/1 15:13
 *  @date  2022/9/23 14:39
 */
@RestController
public class MyParam {

    /**
     * 方法 1 使用 HttpServletRequest 接收
     */
    @RequestMapping("/demo")
    public String getParam(HttpServletRequest request) {
        System.out.println(request);
        System.out.println("myParam:" + request.getParameter("username"));
        HttpServletRequest req = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        System.out.println("从上下文中直接拿:" + req.getParameter("username"));
        String ip = ServletUtil.getClientIP(req);
        return ip;
    }

    /**
     * 方法 2 使用 RequestParam 接收
     */
    @RequestMapping("/demo2")
    public String getParam2(@RequestParam(value = "username") String userName) {
        return userName;
    }

    /**
     * 方法 3 与 方法 2 相同，只是变量名相同可以简化书写
     */
    @RequestMapping("/demo3")
    public String getParam3(String userName) {
        return userName;
    }

    @RequestMapping("/demo4/{userName}")
    public String getParam4(@PathVariable String userName) {
        return userName;
    }

    @RequestMapping("/demo5")
    public String parma5(@RequestBody String xxx) {
        System.out.println("nnn:"+xxx);
        return xxx;
    }

}
