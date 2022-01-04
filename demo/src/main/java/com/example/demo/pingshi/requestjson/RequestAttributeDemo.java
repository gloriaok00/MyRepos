package com.example.demo.pingshi.requestjson;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description @RequestAttribute学习
 * @date 2022-01-04 15:22
 */

@RestController
public class RequestAttributeDemo {

    @ModelAttribute
    void beforeInvokingHandlerMethod(HttpServletRequest request) {
        request.setAttribute("foo", "hello world");
    }

    @RequestMapping(value="/data/custom", method= RequestMethod.GET)
    public @ResponseBody
    String custom(@RequestAttribute("foo") String foo,String tt) {
        return "Got 'foo' request attribute value '" + foo + "'"+"and param is "+tt;
    }
}
