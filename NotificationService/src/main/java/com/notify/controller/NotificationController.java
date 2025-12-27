package com.notify.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notify.model.NotificationRequest;
import com.notify.service.NotificationService;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {
	
	private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/notifyScheduledInterview")
    public ResponseEntity<String> sendInterviewSchedule(@RequestBody NotificationRequest request) {
        notificationService.sendInterviewScheduledNotification(request);
        return ResponseEntity.ok("SENT");
    }
    
    @PostMapping("/notifyFeedback")
    public ResponseEntity<String> sendFeedback(@RequestBody NotificationRequest request) {
        notificationService.sendFeedbackNotification(request);
        return ResponseEntity.ok("SENT");
    }

}
