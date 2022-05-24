package com.example.demo.mbs.lianxi.mb1;

import com.example.demo.mbs.m1.dao.UUserMapper;
import com.example.demo.mbs.m1.model.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description
 * @date 2022/5/24 12:29
 */

@RestController
@RequestMapping("/mb")
public class MBDemo {

    @Autowired
    private UUserMapper userMapper;

    @GetMapping("/scd")
    public void sqlCusDefinition(){

        List<UUser> users= userMapper.selectList(null);
        System.out.println(users.get(0).getUsername());
    }
}
