package com.notify.service;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.notify.model.NotificationRequest;
import com.notify.model.Recipient;

@Service
public class EmailNotificationService implements NotificationService{
	
	private final EmailService emailService;
	
	 public EmailNotificationService(EmailService emailService) {
	        this.emailService = emailService;
	    }

	@Override
	public void sendInterviewScheduledNotification(NotificationRequest req) {
		// TODO Auto-generated method stub
		
		for(Recipient to : req.receipients()) {
				
			if(to.email()!=null || !to.email().isBlank()) {
				emailService.sendEmail(to.email(), "Interview Scheuled", req.message());
			}
		}
		
		
	}

	@Override
	public void sendFeedbackNotification(NotificationRequest req) {
		// TODO Auto-generated method stub
		
		for(Recipient to : req.receipients()) {
			
			if(to.email()!=null || !to.email().isBlank()) {
				emailService.sendEmail(to.email(), "Feedback for your Interview", req.message());
			}
		}
		
	}

}
