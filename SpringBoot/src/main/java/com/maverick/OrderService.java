package com.maverick;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void orderStatus() {
        System.out.println("Order initiated");
        paymentService.pay();
    }
}
