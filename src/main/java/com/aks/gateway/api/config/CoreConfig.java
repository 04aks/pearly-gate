package com.aks.gateway.api.config;

import com.aks.core.facade.Pearly;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {
    @Bean
    public Pearly pearly(){
        return new Pearly();
    }
}
