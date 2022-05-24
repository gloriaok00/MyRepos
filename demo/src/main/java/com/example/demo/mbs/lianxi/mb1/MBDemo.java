package com.example.demo.mbs.lianxi.mb1;

import com.example.demo.mbs.cus.dao.UserDao;
import com.example.demo.mbs.m1.model.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description mybatis基础练习
 * @date 2022/5/24 12:29
 */

@RestController
@RequestMapping("/mb")
public class MBDemo {

    @Autowired
    private UserDao userDao;

    @GetMapping("/scd")
    public void sqlCusShow(){
        List<UUser> users= userDao.sqlCusShow();
        users.forEach(e->{
            System.out.println(e.getUsername());
        });
    }
}
