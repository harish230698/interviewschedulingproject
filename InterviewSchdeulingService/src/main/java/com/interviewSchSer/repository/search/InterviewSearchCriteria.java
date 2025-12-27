package com.interviewSchSer.repository.search;

import java.time.LocalDateTime;
import java.util.UUID;

public interface InterviewSearchCriteria {
	
	 	UUID getInterviewId();
	    String getCandidateName();
	    String getInterviewerName();
	    LocalDateTime getScheduledTime();
	    String getStatus();
}
