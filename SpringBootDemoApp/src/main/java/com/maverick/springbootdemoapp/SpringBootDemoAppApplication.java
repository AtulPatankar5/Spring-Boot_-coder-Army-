package com.maverick.springbootdemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBootDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAppApplication.class, args);
    }

}
