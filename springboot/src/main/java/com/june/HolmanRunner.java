package com.june;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class HolmanRunner implements ApplicationRunner {

    @Autowired
    Holman holman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holman);
    }
}
