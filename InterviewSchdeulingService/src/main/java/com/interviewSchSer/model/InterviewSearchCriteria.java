package com.interviewSchSer.model;

import java.util.UUID;

public record InterviewSearchCriteria(
		
		String interviewerName,
		String candidateName,
		UUID interviewId
		) {

}
