package com.example.demo.pingshi.mylombok.lom;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @description
 * @date 2022-04-23 13:29
 */

@Slf4j
public class LM {

    public static void main(String[] args) {
        LChild childTest1 = new LChild();
        childTest1.setCode("1");
        childTest1.setName("child");

        LChild childTest2 = new LChild();
        childTest2.setCode("2");
        childTest2.setName("child");

        boolean isSame = Objects.equals(childTest1,childTest2);
        log.info("testEquals -> childTest1:{}, childTest2:{}", childTest1, childTest2);
        log.info("testEquals -> :{}", isSame);
    }
}
