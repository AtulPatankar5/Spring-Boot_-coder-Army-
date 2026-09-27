package com.maverick.springbootdemo;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        this.paymentProperties = paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

    public boolean getEnabled() {
        return paymentProperties.Enabled();
    }

    public void printPayment() {
        System.out.println(getType());
        System.out.println(getRetryCount());
        System.out.println(getEnabled());
        System.out.println(getTimeout());
    }
}
