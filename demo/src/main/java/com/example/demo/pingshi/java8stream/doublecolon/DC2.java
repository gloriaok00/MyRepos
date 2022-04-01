package com.example.demo.pingshi.java8stream.doublecolon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
/**
 * @date 2022-03-31 18:39
 */
@RunWith(SpringRunner.class)
public class DC2 {
	@Test
	public void test() {
		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");

		//对象实例语法	instanceRef::methodName
		list.forEach(new DC2()::print);
	}

	public void print(String content){
		System.out.println(content);
	}
}
