package com.interviewer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.interviewer.entity.AvailabilityStatus;
import com.interviewer.model.InterviewerRequest;
import com.interviewer.model.InterviewerResponse;

@Service
public interface InterviewerService {
	
	
	InterviewerResponse createInterviewer(InterviewerRequest request);

    InterviewerResponse getInterviewer(UUID id);

    List<InterviewerResponse> getAvailableInterviewers();

    void updateAvailability(UUID id, AvailabilityStatus status);

}
