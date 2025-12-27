package com.interviewSchSer.clientservices;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.interviewSchSer.model.InterviewerDTO;

import lombok.RequiredArgsConstructor;

import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.springframework.beans.factory.annotation.Value;

@Component
@RequiredArgsConstructor
public class InterviewerClient {
	
	@Value("${interviewer.service.baseurl}")
	private String interviewerUrl;
	
	private final RestTemplate restTemplate;
	
	private final CloseableHttpClient httpClient;

    public InterviewerDTO getInterviewer(UUID id) {
        return restTemplate.getForObject(
        		interviewerUrl + "/getInterviewer/" + id,
                InterviewerDTO.class
        );
    }

    public void updateStatus(UUID id, String status) {
        
        String url = interviewerUrl + "/updateStatus/" + id + "/availability?status=" + status;
        
        HttpPatch httpPatch = new HttpPatch(url);
    	
    	httpPatch.setHeader("Content-Type","application/json");
    	
    	CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPatch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
