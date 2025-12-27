package com.feedback.model;

import java.util.UUID;

import com.feedback.entity.Decision;

public record FeedbackResponse(
		UUID id,
		UUID interviewId,
		int rating,
		String comments,
		Decision decision
		) {

}
