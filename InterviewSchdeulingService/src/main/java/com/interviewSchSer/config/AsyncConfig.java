package com.interviewSchSer.config;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	private static final int CORE_POOL_SIZE = 5;
	private static final int QUEUE_CAPACITY = 100;
	private static final int MAX_POOL_SIZE = 10;
	
	@Bean(name = "interviewExecutor")
    public Executor interviewExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix("Interview-");
        executor.initialize();
        return executor;
    }

}
