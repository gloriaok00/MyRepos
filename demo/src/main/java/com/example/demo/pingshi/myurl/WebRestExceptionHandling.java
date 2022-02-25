package com.example.demo.pingshi.myurl;

import com.example.demo.pingshi.myexception.CustomerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@ControllerAdvice
public class WebRestExceptionHandling extends ResponseEntityExceptionHandler {

    /**
     * Handles a system exception by setting the HTML response code and response
     * headers.
     *
     */
    @ExceptionHandler(value = { CustomerException.class })
    protected ResponseEntity<Object> handleSystemException(CustomerException e, WebRequest request) throws UnsupportedEncodingException {
	String combined = e.getCode() + ":" + e.getMsg();
	HttpHeaders headers = new HttpHeaders();
	headers.add("Cus_ErrorMsg", URLEncoder.encode(e.getMsg(),"UTF-8").replaceAll("\\+", "%20"));
	headers.add("Cus_ErrorCode", String.valueOf(e.getCode()));
	HttpStatus responseCode = HttpStatus.BAD_REQUEST;
	return handleExceptionInternal(e, combined, headers, responseCode, request);
    }

}
