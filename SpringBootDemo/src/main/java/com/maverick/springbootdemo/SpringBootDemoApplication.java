package com.maverick.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.orderStatus();

//        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);


    }
}
