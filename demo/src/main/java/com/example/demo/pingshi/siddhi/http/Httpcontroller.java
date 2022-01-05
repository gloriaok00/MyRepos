package com.example.demo.pingshi.siddhi.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyu
 * @description siddhi http request/response test
 * @date 2021-04-08 04:50
 */

@RestController
@ResponseBody
@Slf4j
public class Httpcontroller {

    @PostMapping("/validate-loan")
    public ValidationResponse validateLoan(@RequestBody ValidateLoan validateLoan) {
        log.info(validateLoan.getName());
        ValidationResponse response = new ValidationResponse(true, 23.231, 5);
        return response;
    }
}
