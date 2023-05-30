package com.demo.exerciseTwo;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    private NotificationService notificationService;

    public UserService(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
