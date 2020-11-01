package com.example.demo.pingshi.env;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书操作
 * 测试这个包下边的文件是否是info级别
 * @author zhangyu
 * @date 2020/10/12 23:28
 */

@Slf4j
@RestController(value = "/dddddddd")
public class MyRest {

    @GetMapping("/tt")
    public String getBookById(){
        log.debug("debug getBookById2");
        log.info("info getBookById2");
        return "2";
    }
}
