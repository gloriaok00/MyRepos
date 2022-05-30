package com.example.demo.pingshi.mytrans.t1;

import com.example.demo.mbs.cus.dao.UUserMapper;
import com.example.demo.mbs.cus.dto.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2022/5/29 13:30
 */

@RestController
@RequestMapping("/trans")
public class MyTrans {

    @Autowired
    private UUserMapper uUserMapper;

    @Autowired
    private TransM transM;

    @Autowired
    private TransMySql transMysql;


    @GetMapping("/roll")
    @Transactional
    public void transRoll(){

        transMysql.transMysql();

        //步骤2
        UUser user=uUserMapper.selectById(3L);
        user.setUpdateTime(null);
        user.setRemark(String.valueOf(Math.random()));
        uUserMapper.updateById(user);

        if(true){
            throw new RuntimeException("后面的方法抛异常了");
        }
    }

}
