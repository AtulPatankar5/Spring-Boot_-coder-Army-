package com.maverick._8_profiledemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class SMSNotificationServiceImpl implements NotificationService {

    @Override
    public String send() {
        return "SMS Notification Service";
    }
}
