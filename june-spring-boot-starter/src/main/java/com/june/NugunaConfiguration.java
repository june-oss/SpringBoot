package com.june;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NugunaProperties.class)
public class NugunaConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Nuguna nuguna(NugunaProperties properties){
        Nuguna nuguna = new Nuguna();

        nuguna.setName(properties.getName());
        nuguna.setHowLong(properties.getHowLong());

        return nuguna;
    }
}
