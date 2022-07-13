package com.example.demo.pingshi.mytrans.t2.logic;

import com.example.demo.pingshi.mytrans.t2.dao.T1Mapper;
import com.example.demo.pingshi.mytrans.t2.dao.T2Mapper;
import com.example.demo.pingshi.mytrans.t2.model.T1;
import com.example.demo.pingshi.mytrans.t2.model.T2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 1.确实是private修饰的不行 2.同一个类中两个不同的方法不行
 * 3.正常来说只有抛出的runtime异常才会被捕获 但用rollback也可以强行指定各种异常
 * @date 2022/7/9 23:30
 */

@RestController
public class Trans2 {

    @Autowired
    private T1Mapper m1;

    @Autowired
    private TransOther bb;

    @Autowired
    private T2Mapper m2;

    @GetMapping(value = "/trans/t1")
    @Transactional
    public void t1(){
        T1 t1 = new T1();
        t1.setName("sdsad");
        m1.insert(t1);
        T2 t2 = new T2();
        t2.setId(1);
        bb.t2(t2);
    }


   /* public void t2(T2 t2) {
        m2.insert(t2);
        throw new IndexOutOfBoundsException("dsfdsf");
    }*/

}
