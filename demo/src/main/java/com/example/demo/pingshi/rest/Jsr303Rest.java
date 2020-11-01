package com.example.demo.pingshi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhangyu
 * @date 2020/3/26 09:37
 */
@RestController
public class Jsr303Rest {

    @GetMapping(value = "/test/jsr")
    public String validatorParam(@Valid @RequestBody PersonImportDTO personImportDTO){
        return personImportDTO.toString();
    }

}
