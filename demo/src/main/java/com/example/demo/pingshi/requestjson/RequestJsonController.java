package com.example.demo.pingshi.requestjson;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pingshi.java8stream.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.HashMap;

/**
 * @author zhangyu
 * @date 2019/12/1 12:46
 */
@RestController
@CrossOrigin(origins = "*")
public class RequestJsonController {

    @PostMapping(value = "/requestjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public void Test(HttpServletRequest request) {
        System.out.println(request.getParameter("age"));
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("name"));
    }

    //form-data 这种接受json比较麻烦 大概是这个思路，通过读流 然后解析文本
    @PostMapping(value = "/requestjsonform", produces = MediaType.APPLICATION_JSON_VALUE)
    public void TestForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("进入=====================");

        //  request.getReader();方法返回一个包含body体数据的BufferedReader；
        BufferedReader reader = request.getReader();
        String readerStr = "";// 接收用户端传来的JSON字符串（body体里的数据）
        String line;
        while ((line = reader.readLine()) != null) {
            readerStr = readerStr.concat(line);
        }

        // 使用阿里的fastjson jar包处理json数据（这里是用map进行接收的，你也可以定义vo层容器类接收）
        HashMap map = JSONObject.parseObject(readerStr, HashMap.class);
        System.out.println(map.get("user"));
    }

    //postman里发raw json
    //html里var jsondata=xx  data: JSON.stringify(jsondata),
    @PostMapping(value = "/requestjsonbody", produces = MediaType.APPLICATION_JSON_VALUE)
    public void TestJson(@RequestBody Student student) {
        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getAge());
    }
}
