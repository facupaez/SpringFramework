package com.demo.exerciseTwo;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public String printGreeting(){
        return "Hello user!";
    }
}
