package com.maverick.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class CardService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Payment done by Card");
    }
}
