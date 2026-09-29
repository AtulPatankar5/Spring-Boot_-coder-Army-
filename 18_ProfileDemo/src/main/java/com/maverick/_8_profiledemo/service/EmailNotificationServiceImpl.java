package com.maverick._8_profiledemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class EmailNotificationServiceImpl implements NotificationService {

    @Override
    public String send() {
        return "Email Notification Service";
    }
}
