package com.interviewer.utils;


import com.interviewer.entity.InterviewerEntity;
import com.interviewer.model.InterviewerResponse;

public class ResponseMapper {
	
	public static InterviewerResponse entityToResponse(InterviewerEntity entity) {
		
		return new InterviewerResponse(
				entity.getId(),
				entity.getName(),
				entity.getEmail(),
				entity.getDesignation(),
				entity.getSkill(),
				entity.getStatus()
				);
		
	}

}
