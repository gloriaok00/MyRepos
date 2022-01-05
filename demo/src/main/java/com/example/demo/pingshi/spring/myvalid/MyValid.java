package com.example.demo.pingshi.spring.myvalid;

import com.example.demo.pingshi.spring.myvalid.fenzu.UpdateGroup;
import com.example.demo.pingshi.spring.myvalid.fenzu.ValidItem;
import com.example.demo.pingshi.spring.myvalid.qiantao.MyParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    //嵌套(需要被嵌套的类上一定要有@valid)
    @PostMapping("/valid")
    public void show(@Validated @RequestBody MyParam param) {
        System.out.println("valid:" + param.paramId);
    }

    //复习:@Validated加在类名上，在方法参数旁边的这些校验才好使
    @GetMapping("/valid2")
    public int show2(@RequestParam @Min(1) @Max(10) int id) {
        return id;
    }

    //@NotBlank只能用于String上
    @GetMapping("/valid3")
    public String show3(@RequestParam @NotBlank String id) {
        return id;
    }

    //分组
    @GetMapping("/valid4")
    public String show4(@Validated(UpdateGroup.class) @RequestBody ValidItem item) {
        return item.getName();
    }

    //分组
    @GetMapping("/valid5")
    public String show5(@Validated @RequestBody ValidItem item) {
        return item.getName();
    }
}
