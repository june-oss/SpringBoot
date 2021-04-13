package com.june;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class NugunaRunner implements ApplicationRunner {

    @Autowired
    Nuguna nuguna;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(nuguna);
    }
}
