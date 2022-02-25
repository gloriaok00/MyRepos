package com.example.demo.pingshi.myurl;

import com.example.demo.pingshi.myexception.CustomerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

/**
 * @description header url加密
 * @date 2022-02-25 16:27
 */

@RestController
public class MyURLEncode {

    @GetMapping(value = "/jiami")
    public void tdddd() throws CustomerException {
        throw new CustomerException("111", "中文 我爱你yyds");
    }

    public static void main(String[] args) {
        System.out.println(URLDecoder.decode("%E4%B8%AD%E6%96%87%20%E6%88%91%E7%88%B1%E4%BD%A0yyds"));
    }
}
