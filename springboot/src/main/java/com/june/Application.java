package com.june;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

//    @Bean
//    public Nuguna nuguna(){
//        Nuguna nuguna = new Nuguna();
//        nuguna.setHowLong(14);
//        nuguna.setName("wafour");
//        return nuguna;
//    }

}
