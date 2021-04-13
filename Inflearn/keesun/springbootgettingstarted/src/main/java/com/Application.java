package com;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//@SpringBootApplication

//@Configuration //@SpringBootConfiguration과 동일
//@ComponentScan
//@EnableAutoConfiguration    //이게 없으면 기본적인 DI가 되지않는다.
public class Application {

//    public static void main(String[] args) {
//        //SpringApplication을 직접 등록해서 사용하면(static method를 사용하지않고) 사용자가 커스터마이징해서 사용가능
//        SpringApplication application = new SpringApplication(Application.class);
//        //아래설정은 application을 webappliction이 아닌 기본 application을 띄우는 설정이다.
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);
//    }

    //내장 웹서버 이해
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        Context context = tomcat.addContext("/", "/");

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey, Tom");
                writer.println("</title></head>");
                writer.println("<body><h1>Hello tom </h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/", servletName, servlet);
        context.addServletMappingDecoded("/hello", servletName);



        tomcat.start();
        tomcat.getServer().await();


    }
}
