package com.example.demo.pingshi.http;

import com.example.demo.pingshi.rest.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 *  @description 接口实现随机练习
 *  @date  2022/8/18 11:17
 */
@Slf4j
public class RetrySendSms {

    public static void main(String[] args) {
        Callable<String> xx=()->{
            return "dfsdf";
        };
        Callable<Boolean> x1=new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return false;
            }
        };
    }

    class MyTask implements Callable<Person>{

        @Override
        public Person call() throws Exception {
            return new Person();
        }
    }
}
