package org.example.zz;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @description
 * @date 2022/7/25 17:05
 */

@RequestMapping(value = "/cc")
@RestController
public class CCC {

    @GetMapping(value = "/nn")
    public String show() {

        return "这是夺标";

    }
}
