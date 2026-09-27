package com.maverick;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Lazy
public class OrderService {

    public OrderService() {
        System.out.println("Order Service Created ");
    }

    public void placeOrder() {
        System.out.println("Order placed");
    }
}
