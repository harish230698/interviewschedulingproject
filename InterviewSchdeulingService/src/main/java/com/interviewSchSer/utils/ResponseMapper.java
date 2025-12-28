package com.interviewSchSer.utils;

import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.interviewSchSer.entity.InterviewEntity;
import com.interviewSchSer.model.InterviewResponse;
import com.interviewSchSer.model.InterviewSearchViewResponse;
import com.interviewSchSer.repository.search.InterviewSearchViewEntity;

public class ResponseMapper {
	
	public static InterviewResponse enityToResponse(InterviewEntity entity) {
		
		InterviewResponse resp = new InterviewResponse(
				entity.getId(),
				entity.getCandidateId(),
				entity.getInterviewerId(),
				entity.getScheduledTime(),
				entity.getMode(),
				entity.getStatus()
				);
		
		return resp;
	}

public static InterviewSearchViewResponse enityToSearchViewResponse(InterviewSearchViewEntity entity) {
		
	InterviewSearchViewResponse resp = new InterviewSearchViewResponse(
				entity.getInterviewId(),
				entity.getCandidateId(),
				entity.getCandidateName(),
				entity.getInterviewerId(),
				entity.getInterviewerName(),
				entity.getScheduledTime(),
				entity.getStatus(),
				entity.getCandidateEmail(),
				entity.getInterviewerEmail()
				);
		
		return resp;
	}
}
