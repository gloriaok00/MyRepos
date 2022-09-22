package com.example.demo.pingshi.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @description 终于验证了直接返回String会找那些template view啥的 还得是用response才行
 * @date 2022/9/20 17:07
 */

@Controller
public class CtrlResponse {

    @GetMapping("/ctrl/rep")
    public void xx(HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        out.write("我是测试".getBytes(StandardCharsets.UTF_8));
    }
}
