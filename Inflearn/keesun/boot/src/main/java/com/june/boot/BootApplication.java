package com.june.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootApplication {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run(args);

	}

}
