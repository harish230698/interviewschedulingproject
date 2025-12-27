package com.feedback.model;

import java.util.UUID;

import com.feedback.entity.Decision;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record FeedbackRequest(
		
		@NotNull
		UUID interviewId,
		
		@NotNull
		UUID interviewerId,
		
		@Min(1)
		@Max(5)
		int rating,
		
		String comments,
		
		@NotNull
		Decision decision
		
		
		) {

}
