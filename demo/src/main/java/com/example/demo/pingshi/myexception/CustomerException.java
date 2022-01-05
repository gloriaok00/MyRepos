package com.example.demo.pingshi.myexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 多数情况下，创建自定义异常需要继承Exception，本例继承Exception的子类RuntimeException
 *
 * @author Mahc
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CustomerException extends RuntimeException {

    private String code;  //异常对应的返回码
    private String msg;  //异常对应的描述信息

}
