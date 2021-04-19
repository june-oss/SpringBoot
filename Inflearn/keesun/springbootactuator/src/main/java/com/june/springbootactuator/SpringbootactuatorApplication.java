package com.june.springbootactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootactuatorApplication {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	//terminal에서 jConsole or jvisualvm 입력
	public static void main(String[] args) {
		SpringApplication.run(SpringbootactuatorApplication.class, args);
	}

}
