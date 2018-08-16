package com.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController(value = "messageController")
public class MessageServiceApplication {
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageServiceApplication.class, args);
	}
}
