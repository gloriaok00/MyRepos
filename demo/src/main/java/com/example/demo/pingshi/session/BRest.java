package com.example.demo.pingshi.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书操作
 * 测试这个包下边的文件是否是debug级别
 *
 * @author zhangyu
 * @date 2020/10/12 23:26
 */

@Slf4j
@RestController
public class BRest {

    /**
     * 根据ID查找书籍
     */
    @GetMapping("/dd")
    public String getBookById() {
        log.debug("debug getBookById");
        log.info("info getBookById");
        return "1";
    }

}
