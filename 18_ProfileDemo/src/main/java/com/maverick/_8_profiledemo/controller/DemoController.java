package com.maverick._8_profiledemo.controller;

import com.maverick._8_profiledemo.service.NotificationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.ClassGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo")
public class DemoController {

    @Value("${app.welcome.message}")
    private String message;

    @Value("${app.welcome.code}")
    private Integer code;


    private NotificationService notificationService;

    public DemoController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok(message + " - " + code);

    }

    @GetMapping("/notify")
    public ResponseEntity<String> notification() {
        String result = notificationService.send();
        return ResponseEntity.ok(result);
    }
}
