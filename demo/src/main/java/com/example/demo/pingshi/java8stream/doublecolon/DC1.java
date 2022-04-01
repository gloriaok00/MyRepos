package com.example.demo.pingshi.java8stream.doublecolon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @date 2022-03-31 18:25
 */
@RunWith(SpringRunner.class)
public class DC1 {

	@Test
	public void test() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
		//静态方法语法	ClassName::methodName
		list.forEach(DC1::print);
	}

	public static void print(String content){
		System.out.println(content);
	}

}
