package com.example.demo.pingshi.loadResource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @date 2022/7/26 17:42
 */

@RequestMapping("/yy")
@RestController
public class yamlLoad {

    @GetMapping("/load")
    public void show(){
        Map<String, Map<String,Object>> properties=new HashMap();
        InputStream in=this.getClass().getClassLoader().getResourceAsStream("application.yaml");
        Yaml yaml=new Yaml();
        properties=yaml.loadAs(in,HashMap.class);
        Map<String,Object> prop=properties.get("spring");
        Object xx=prop.get("output");
        System.out.println("xxx:"+xx);
    }
}
