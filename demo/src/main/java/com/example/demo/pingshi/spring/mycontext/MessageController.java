package com.example.demo.pingshi.spring.mycontext;

import com.example.demo.pingshi.spring.mybean.myauto.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private Woman myWoman;

	@GetMapping("/echo")
	public void echo(String mid){
		System.out.println(myWoman.runMarathon());
	}

}
