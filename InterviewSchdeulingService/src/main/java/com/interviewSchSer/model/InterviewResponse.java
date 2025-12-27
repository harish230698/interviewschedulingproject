package com.interviewSchSer.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.interviewSchSer.entity.InterviewMode;
import com.interviewSchSer.entity.InterviewStatus;

public record InterviewResponse(
		UUID id,
		UUID candidateId,
		UUID interviewerId,
		LocalDateTime scheduledTime,
		InterviewMode mode,
		InterviewStatus status) {

}
