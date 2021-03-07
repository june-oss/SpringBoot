package com.june;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Holman holman(){
        Holman holman = new Holman();
        holman.setHowLong(26);
        holman.setName("HyeonJung");
        return holman;
    }
}
