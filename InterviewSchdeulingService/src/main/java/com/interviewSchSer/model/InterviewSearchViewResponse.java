package com.interviewSchSer.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.interviewSchSer.entity.InterviewStatus;

public record InterviewSearchViewResponse(
		UUID interviewId,
		UUID candidateId,
		String candidateName,
		UUID interviewerId,
		String interviewerName,
		LocalDateTime scheudledTime,
		InterviewStatus status,
		String candidateEmail,
		String interviewEmail) {
}
