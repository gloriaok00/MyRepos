package com.example.demo.mbs.lianxi.mb1;

import com.example.demo.mbs.cus.dao.UserDao;
import com.example.demo.mbs.cus.dto.DuplicateDataRsp;
import com.example.demo.mbs.m1.model.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/dup/data")
    public void duplicationData(){
        List<DuplicateDataRsp> rr= userDao.duplicateData();
        rr.forEach(e-> System.out.println(e.toString()));
    }

    @GetMapping("/param/learn")
    public void paramLearn(@RequestParam Long id,@RequestParam String name){
        List<UUser> rr= userDao.paramLearn(id,name);
        rr.forEach(e-> System.out.println(e.toString()));
    }

    @GetMapping("/param/learn/script")
    public void paramLearnScript(@RequestParam Long id,@RequestParam String name){
        List<UUser> rr= userDao.paramLearnScript(id,name);
        rr.forEach(e-> System.out.println(e.toString()));
    }

    @GetMapping("/char/diff")
    public void charDiff(@RequestParam String username,@RequestParam String tableName){
        List<UUser> rr= userDao.charDiff(tableName,username);
        rr.forEach(e-> System.out.println(e.toString()));
    }

    @GetMapping("/resultMap/learn")
    public void resultMapLearn(){
        List<UUser> rr= userDao.resultMapLearn();
        rr.forEach(e-> System.out.println(e.getId()));
    }
}
