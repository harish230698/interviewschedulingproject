package com.interviewSchSer.clientservices;


import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.interviewSchSer.model.CandidateDTO;

import lombok.RequiredArgsConstructor;

import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.tomcat.util.http.fileupload.util.Closeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Component
@RequiredArgsConstructor
public class CandidateClient {
	
	@Value("${candidate.service.baseurl}")
	private String candidateUrl;
	
	private final RestTemplate restTemplate;
	
	private final CloseableHttpClient httpClient;

    public CandidateDTO getCandidate(UUID id) {
        return restTemplate.getForObject(
                candidateUrl + "/getCandidateById/" + id,
                CandidateDTO.class
        );
    }

    public void updateStatus(UUID id, String status) {
    	
    	String url = candidateUrl + "/updateStatus/" + id + "/status?status=" + status;
    	
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
