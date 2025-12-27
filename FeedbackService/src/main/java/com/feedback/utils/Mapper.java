package com.feedback.utils;

import com.feedback.entity.FeedbackEntity;
import com.feedback.model.FeedbackRequest;
import com.feedback.model.FeedbackResponse;

public class Mapper {
	
	public static FeedbackResponse entityToResponse(FeedbackEntity entity) {
		
		return new FeedbackResponse(
				entity.getId(),
				entity.getInterviewId(),
				entity.getRating(),
				entity.getComments(),
				entity.getDecision());
	}
	
	public static FeedbackEntity requestToEntity(FeedbackRequest request) {
		
		FeedbackEntity entity = new FeedbackEntity();
		
		entity.setInterviewId(request.interviewId());
		entity.setInterviewerId(request.interviewerId());
		entity.setRating(request.rating());
		entity.setComments(request.comments());
		entity.setDecision(request.decision());
		
		return entity;
	}

}
