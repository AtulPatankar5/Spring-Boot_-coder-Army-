package com.maverick;

import com.maverick.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

    public OrderService(@Qualifier("cardService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }
//    @Autowired
//    public void setpayment(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }


    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order placed");

    }

}
