package com.feedback.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.feedback.model.FeedbackRequest;
import com.feedback.model.FeedbackResponse;

@Service
public interface FeedbackService {
	
	  FeedbackResponse submitFeedback(FeedbackRequest request);

	  FeedbackResponse getByInterviewId(UUID interviewId);
	  
	  List<FeedbackResponse> getByInterviewerId(UUID interviewerId);

}
