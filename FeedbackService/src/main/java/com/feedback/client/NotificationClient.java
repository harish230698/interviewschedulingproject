package com.feedback.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.feedback.model.NotificationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationClient {
	
	@Value("${notification.service.baseurl}")
	private String notificationServiceUrl;
	
	private final RestTemplate rest;
	
	public void notifyFeedback(NotificationDTO notifyReq) {
		
		rest.postForEntity(
	                notificationServiceUrl + "/notifyFeedback",
	                notifyReq,
	                Void.class
	        );
	}

}
