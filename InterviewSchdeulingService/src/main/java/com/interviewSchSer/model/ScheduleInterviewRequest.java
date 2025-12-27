package com.interviewSchSer.model;

import java.time.LocalDateTime;
import java.util.UUID;


import com.interviewSchSer.entity.InterviewMode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ScheduleInterviewRequest(
		
		@NotNull(message = "Candidate id must not be null")
		UUID candidateId,
		
		@NotNull(message = "Interviewer id must not be null")
	    UUID interviewerId,
	    
	    @NotNull
	    LocalDateTime scheduledTime,
	    
	    @NotBlank
	    InterviewMode mode) {

}
