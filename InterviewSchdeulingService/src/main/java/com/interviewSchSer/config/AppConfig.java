package com.interviewSchSer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import org.springframework.context.annotation.Bean;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
public class AppConfig {

	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Bean
    public CloseableHttpClient closeableHttpClient() {
        return HttpClients.createDefault();
    }
}
