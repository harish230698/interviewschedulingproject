package com.interviewSchSer.clientservices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.interviewSchSer.model.NotificationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NotificationClient {
	
	@Value("${notification.service.baseurl}")
	private String notificationServiceUrl;
	
	private final RestTemplate rest;
	
	public void notifyInterviewScheduled(NotificationDTO notifyReq) {
		
		rest.postForEntity(
	                notificationServiceUrl + "/notifyScheduledInterview",
	                notifyReq,
	                Void.class
	        );
	}

}
