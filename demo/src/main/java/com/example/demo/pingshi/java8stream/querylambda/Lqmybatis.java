package com.example.demo.pingshi.java8stream.querylambda;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.demo.mbs.cus.dao.UUserMapper;
import com.example.demo.mbs.cus.dto.UUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *  @description LambdaQuery 体验
 *  @date  2022/5/30 11:10
 */

//@Component
@SpringBootTest
@RunWith(SpringRunner.class)
public class Lqmybatis {

    @Autowired
    private UUserMapper uUserMapper;

    @Test
    public void transMysql(){
        //步骤1
        List<UUser> users = new LambdaQueryChainWrapper<UUser>(uUserMapper)
                .like(UUser::getUsername, "fish").eq(UUser::getPhone, "13478998787").list();
       users.forEach(System.out::println);
    }
}
