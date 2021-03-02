package com.june;

import org.springframework.context.annotation.Bean;

public class HolomanConfiguration {

    @Bean
    public Holman holman(){
        Holman holman = new Holman();
        holman.setHowLong(26);
        holman.setName("HyeonJung");
        return holman;
    }
}
