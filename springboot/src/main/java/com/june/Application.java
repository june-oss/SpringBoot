package com.june;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Application.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Holman holman(){
        Holman holman = new Holman();
        holman.setName("Hyeonjung");
        holman.setHowLong(28);
        return holman;
    }

}
