package com.example.demo.pingshi.spring.myvalid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @description rest @Validated 学习 终于整明白@RequestParam上要怎么加校验了！@Validated一定要加在类名上
 * 加在方法或参数旁边都不行
 * 另外，竟然偶然的发现了项目启动慢的原因: 在启动时，这里hostname解析不了 zhangyudeMacBook-Pro.local
 * @date 2021-12-15 20:11
 */

@RestController
@Validated
public class MyValid {

    @GetMapping("/valid")
    public void show(@Valid @RequestBody MyParam param){
        System.out.println("valid:"+param.id);
    }

    @GetMapping("/valid2")
    public void show2(@RequestParam @Min(1) @Max(10) int id){
        System.out.println("valid2:"+id);
    }

    @GetMapping("/valid3")
    public void show3(@RequestParam @NotBlank String id){
        System.out.println("valid3:"+id);
    }


}
