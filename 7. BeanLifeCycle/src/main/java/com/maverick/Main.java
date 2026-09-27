package com.maverick;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService service = context.getBean(OrderService.class);
//        service.placeOrder();
        CartService cart = context.getBean(CartService.class);
        System.out.println(cart.getValue(1));
        context.close();
    }
}