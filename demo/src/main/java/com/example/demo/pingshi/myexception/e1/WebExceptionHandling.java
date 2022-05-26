/*
 * Copyright (c) SuperLink, LLC. All rights reserved. http://www.superlink.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package com.example.demo.pingshi.myexception.e1;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
@Slf4j
@Component
@RestControllerAdvice
public class WebExceptionHandling {

    @ExceptionHandler(value = { ExpiredJwtException.class })
    protected String handleJwtExpired(ExpiredJwtException e, WebRequest request) {
        System.out.println("进来了啊");
        return e.getMessage()+"成功被WebExceptionHandling捕获呀";
    }



    @ExceptionHandler(value = { RuntimeException.class })
    protected String handleRuntimeException(RuntimeException e, WebRequest request) {
	log.error("Showing internal server error due to unhandled runtime exception.", e);
	return "运行时异常啊";
    }
}
