package com.maverick;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService
//        implements InitializingBean
{

    Map<Integer, String> map;

    public CartService() {
        map = new HashMap<>();
        System.out.println("cart Service constructor");
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        map.put(1, "Atul");
//        map.put(2, "shivani");
//        System.out.println("Value added");
//    }

//    public void start() {
//        map.put(1, "Atul");
//        map.put(2, "shivani");
//        System.out.println("Value added");
//    }

    @PostConstruct
    public void start2() {
        map.put(1, "Atul");
        map.put(2, "shivani");
        System.out.println("Value added");
    }

    public String getValue(int key) {
        return map.get(key);
    }

    @PreDestroy
    public void destroying() {
        System.out.println("Destroying...");
    }
}
