package com.example.demo.pingshi.mytrans.t1;

import com.example.demo.mbs.cus.dao.UUserMapper;
import com.example.demo.mbs.cus.dto.UUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *  @description
 *  @date  2022/5/30 11:10
 */

@Component
public class TransMySql {

    @Autowired
    private UUserMapper uUserMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transMysql(){
        //步骤1
        UUser user=uUserMapper.selectById(2L);
        user.setUpdateTime(null);
        user.setRemark(String.valueOf(Math.random()));
        uUserMapper.updateById(user);
    }
}
