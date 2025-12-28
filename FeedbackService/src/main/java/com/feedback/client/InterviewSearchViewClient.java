package com.feedback.client;

import java.util.Map;
import java.util.UUID;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InterviewSearchViewClient {
	
	@Value("${interview.service.baseurl}")
	private String interviewUrl;
	
	private final RestTemplate restTemplate;
	
	public Map<String,Object> getByInterviewId(UUID id){
		
		return restTemplate.getForObject(
									interviewUrl + "/search?interviewId=" + id, 
									Map.class);
	}
	

}
