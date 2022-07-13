package com.example.demo.pingshi.mytrans.t2.logic;

import com.example.demo.pingshi.mytrans.t2.dao.T2Mapper;
import com.example.demo.pingshi.mytrans.t2.model.T2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2022/7/13 20:17
 */

@Component
public class TransOther {

    @Autowired
    private T2Mapper m2;

    public void t2(T2 t2){
        m2.insert(t2);
        throw new IndexOutOfBoundsException("dsfdsf");
    }
}
