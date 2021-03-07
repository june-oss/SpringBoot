package com.june.springbootgettingstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication

@Configuration //@SpringBootConfiguration과 동일
@ComponentScan
//@EnableAutoConfiguration    //이게 없으면 기본적인 DI가 되지않는다.
public class Application {

    public static void main(String[] args) {
        //SpringApplication을 직접 등록해서 사용하면(static method를 사용하지않고) 사용자가 커스터마이징해서 사용가능
        SpringApplication application = new SpringApplication(Application.class);
        //아래설정은 application을 webappliction이 아닌 기본 application을 띄우는 설정이다.
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
