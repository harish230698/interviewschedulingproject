package com.interviewSchSer.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.interviewSchSer.entity.InterviewMode;
import com.interviewSchSer.model.InterviewResponse;

@Service
public interface InterviewService {
	
	InterviewResponse scheduleInterview(UUID candidateId,
            UUID interviewerId,
            LocalDateTime scheduledTime,
            InterviewMode mode);

}
