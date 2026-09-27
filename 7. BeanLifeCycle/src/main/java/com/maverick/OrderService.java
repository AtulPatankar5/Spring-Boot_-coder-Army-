package com.maverick;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
public class OrderService implements BeanNameAware, ApplicationContextAware {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        System.out.println("Order placed");
        paymentService.pay();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("inside set bean name->"+name );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Inside setApplicationContext =>" + applicationContext);
    }
}
