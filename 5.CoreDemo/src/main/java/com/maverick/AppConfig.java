package com.maverick;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.maverick")
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Atul", 232);
    }
}
